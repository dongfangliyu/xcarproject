package com.fintecher.sims.service.impl;

import com.fintecher.sims.entity.*;
import com.fintecher.sims.exception.GeneralException;
import com.fintecher.sims.mapper.AllocationRequestMapper;
import com.fintecher.sims.service.*;
import com.fintecher.sims.util.GeneralEnum;
import com.fintecher.sims.util.ZWDateUtil;
import com.fintecher.sims.vo.*;
import net.sf.jsqlparser.expression.LongValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @System: 进销存
 * @Auther: xiaqun
 * @Description:
 * @Date: Created on 2018/3/13 11:20
 * @Modified By:
 */

@Service
@Transactional(rollbackFor = Exception.class)
public class AllocationRequestServiceImpl extends BaseServiceImpl<AllocationRequest> implements AllocationRequestService {
    @Autowired
    private AllocationRequestMapper allocationRequestMapper;

    @Autowired
    private VehicleService vehicleService;

    @Autowired
    private AllocationVehicleService allocationVehicleService;

    @Autowired
    private AllocationScheduleService allocationScheduleService;

    @Autowired
    private AllocationRecordService allocationRecordService;

    /**
     * @System: 进销存
     * @Auther: xiaqun
     * @Description: 多条件查询调拨申请
     * @Modified By:
     */
    @Override
    public List<AllocationRequestModel> getAllAllocationRequest(String allocationOrderNumber) throws Exception {
        return allocationRequestMapper.getAllAllocationRequest(allocationOrderNumber);
    }

    /**
     * @System: 进销存
     * @Auther: xiaqun
     * @Description: 申请调拨
     * @Modified By:
     */
    @Override
    public void allocationApply(AllocationRequestParam param, UserModel user) throws Exception {
        //保存调度申请
        AllocationRequest allocationRequest = new AllocationRequest();
        //TODO 调拨单号生成规则
//        allocationVehicle.setAllocationRequestId(); //调拨单号
        allocationRequest.setOutCompanyId(param.getOutCompanyId()); //调出门店ID
        allocationRequest.setInCompanyId(param.getInCompanyId()); //调入门店ID
        allocationRequest.setLogisticsType(param.getLogisticsType()); //物流方式
        allocationRequest.setApplyStatus(GeneralEnum.AllocationApproveStatus.IN_CONFIRM.getValue()); //当前状态 待调入方确认
        allocationRequest.setApplicant(user.getId()); //申请人
        allocationRequest.setApplyTime(ZWDateUtil.getNowDateTime()); //申请时间
        allocationRequest.setApplyDepartmentId(user.getDeptId()); //申请部门ID
        allocationRequest.setInHandleStatus(GeneralEnum.ProcessingStatus.UNPROCESSED.getValue()); //调出方处理状态
        allocationRequest.setHeadHandleStatus(GeneralEnum.ProcessingStatus.UNPROCESSED.getValue()); //总部处理状态
        allocationRequest.setOutHandleStatus(GeneralEnum.ProcessingStatus.UNPROCESSED.getValue()); //调出方处理状态
        allocationRequest.setUpdater(user.getId()); //最后操作人
        allocationRequest.setUpdateTime(ZWDateUtil.getNowDateTime()); //最后操作时间
        save(allocationRequest);
        generate(allocationRequest, param, user);
    }

    /**
     * @System: 进销存
     * @Auther: xiaqun
     * @Description: 修改调拨申请
     * @Modified By:
     */
    @Override
    public void modifyAllocationApply(AllocationRequestParam param, UserModel user) throws Exception {
        AllocationRequest allocationRequest = findById(param.getId());
        if (Objects.isNull(allocationRequest)) {
            throw new GeneralException("调拨申请不存在");
        }
        //删除车辆调拨中间表
        AllocationVehicle example = new AllocationVehicle();
        example.setAllocationRequestId(param.getId());
        allocationVehicleService.deleteByWhere(example);

        //修改调拨申请
        allocationRequest.setOutCompanyId(param.getOutCompanyId()); //调出门店ID
        allocationRequest.setInCompanyId(param.getInCompanyId()); //调入门店ID
        allocationRequest.setLogisticsType(param.getLogisticsType()); //物流方式
        allocationRequest.setUpdater(user.getId()); //最后操作人
        allocationRequest.setUpdateTime(ZWDateUtil.getNowDateTime()); //最后操作时间
        update(allocationRequest);
        generate(allocationRequest, param, user);
    }

    /**
     * @System: 进销存
     * @Auther: xiaqun
     * @Description: 保存车辆调拨中间表，生成调拨进度
     * @Modified By:
     */
    private void generate(AllocationRequest allocationRequest, AllocationRequestParam param, UserModel user) {
        for (Long id : param.getVehicleIds()) {
            Vehicle vehicle = vehicleService.findById(id);
            if (Objects.isNull(vehicle)) {
                throw new GeneralException("存在车辆信息丢失");
            }
            if (Objects.equals(vehicle.getVehicleStatus(), GeneralEnum.VehicleStatus.DISABLE.getValue())) {
                throw new GeneralException("存在停用车辆");
            }
            if (Objects.equals(vehicle.getVehicleStatus(), GeneralEnum.VehicleStatus.NOT_IN_STORAGE.getValue())) {
                throw new GeneralException("存在未入库车辆");
            }
            if (Objects.equals(vehicle.getVehicleStatus(), GeneralEnum.VehicleStatus.LOCKED_PREPARE.getValue())) {
                throw new GeneralException("存在整备车锁定车辆");
            }
            if (Objects.equals(vehicle.getVehicleStatus(), GeneralEnum.VehicleStatus.LOCKED_SELL.getValue())) {
                throw new GeneralException("存在销售锁定车辆");
            }
            if (Objects.equals(vehicle.getVehicleStatus(), GeneralEnum.VehicleStatus.LOCKED_TRANSFER.getValue())) {
                throw new GeneralException("存在调度锁定车辆");
            }
            if (Objects.equals(vehicle.getVehicleStatus(), GeneralEnum.VehicleStatus.OUTBOUND_TRANSFER.getValue())) {
                throw new GeneralException("存在调拨出库车辆");
            }
            if (Objects.equals(vehicle.getVehicleStatus(), GeneralEnum.VehicleStatus.SOLD.getValue())) {
                throw new GeneralException("存在已销售锁定车辆");
            }
            vehicle.setVehicleStatus(GeneralEnum.VehicleStatus.LOCKED_TRANSFER.getValue()); //车辆状态
            vehicle.setUpdater(user.getId()); //最后操作人
            vehicle.setUpdateTime(ZWDateUtil.getNowDateTime()); //最后操作时间
            vehicleService.update(vehicle);

            //保存车辆调拨中间表
            AllocationVehicle allocationVehicle = new AllocationVehicle();
            allocationVehicle.setAllocationRequestId(allocationRequest.getId()); //调拨申请ID
            allocationVehicle.setVehicleId(id); //车辆ID
            allocationVehicleService.save(allocationVehicle);
        }
        //生成调拨进度
        AllocationSchedule allocationSchedule = new AllocationSchedule();
        allocationSchedule.setAllocationRequestId(allocationRequest.getId()); //调拨申请ID
        allocationSchedule.setItem(GeneralEnum.AllocationScheduleItem.INITIATE.getValue()); //事项
        allocationSchedule.setOperator(user.getId()); //操作人
        allocationSchedule.setOperateTime(ZWDateUtil.getNowDateTime()); //操作时间
        allocationScheduleService.save(allocationSchedule);
    }

    /**
     * @System: 进销存
     * @Auther: xiaqun
     * @Description: 根据调拨申请查询车辆信息
     * @Modified By:
     */
    public List<VehicleDetailsModel> getVehicleByAllocationId(Long id) throws Exception {
        return allocationRequestMapper.getVehicleByAllocationId(id);
    }

    /**
     * @System: 进销存
     * @Auther: xiaqun
     * @Description: 调拨申请审批
     * @Modified By:
     */
    @Override
    public void approveAllocation(ApproveAllocationParam param, UserModel user) throws Exception {
        AllocationRequest allocationRequest = findById(param.getId());
        if (Objects.isNull(allocationRequest)) {
            throw new GeneralException("调拨申请未找到");
        }
        //生成调拨进度
        AllocationSchedule allocationSchedule = new AllocationSchedule();
        allocationSchedule.setAllocationRequestId(param.getId()); //调拨申请ID
        allocationSchedule.setOperator(user.getId()); //操作人
        allocationSchedule.setOperateTime(ZWDateUtil.getNowDateTime()); //操作时间

        if (Objects.equals(param.getType(), 0)) { //调入方确认
            if (Objects.equals(allocationRequest.getInHandleStatus(), GeneralEnum.ProcessingStatus.PROCESSED.getValue())) {
                throw new GeneralException("调入方已处理");
            }
            allocationRequest.setInHandleStatus(GeneralEnum.ProcessingStatus.PROCESSED.getValue()); //调入方处理结果
            allocationRequest.setInHandler(user.getId()); //调入方审批人
            allocationRequest.setInHandleTime(ZWDateUtil.getNowDateTime()); //调入方审批时间
            if (Objects.equals(param.getApproveResult(), GeneralEnum.ApproveResult.PASS.getValue())) { //审核通过
                allocationRequest.setApplyStatus(GeneralEnum.AllocationApproveStatus.HEADER_CONFIRM.getValue()); //调拨申请状态 待总部审核
                allocationSchedule.setItem(GeneralEnum.AllocationScheduleItem.IN_PASS.getValue()); //调拨进度事项
            } else if (Objects.equals(param.getApproveResult(), GeneralEnum.ApproveResult.REFUSE.getValue())) { //审核拒绝
                allocationRequest.setApplyStatus(GeneralEnum.AllocationApproveStatus.IN_REFUSE.getValue()); //调拨申请状态 调入方拒绝
                allocationRequest.setInHandleRemark(param.getRemark()); //备注信息
                allocationSchedule.setItem(GeneralEnum.AllocationScheduleItem.IN_REFUSE.getValue()); //调拨进度事项
            } else if (Objects.equals(param.getApproveResult(), GeneralEnum.ApproveResult.RETURN.getValue())) { //审核退回
                allocationRequest.setApplyStatus(GeneralEnum.AllocationApproveStatus.IN_RETURN.getValue()); //调拨申请状态 调入方退回
                allocationRequest.setInHandleRemark(param.getRemark()); //备注信息
                allocationSchedule.setItem(GeneralEnum.AllocationScheduleItem.IN_RETURN.getValue()); //调拨进度事项
            } else {
                throw new GeneralException("传参有误");
            }
        } else if (Objects.equals(param.getType(), 1)) { //总部审核
            if (Objects.equals(allocationRequest.getHeadHandleStatus(), GeneralEnum.ProcessingStatus.PROCESSED.getValue())) {
                throw new GeneralException("总部已处理");
            }
            allocationRequest.setHeadHandleStatus(GeneralEnum.ProcessingStatus.PROCESSED.getValue()); //总部处理结果
            allocationRequest.setHeadHandler(user.getId()); //总部审批人
            allocationRequest.setHeadHandleTime(ZWDateUtil.getNowDateTime()); //总部审批时间
            if (Objects.equals(param.getApproveResult(), GeneralEnum.ApproveResult.PASS.getValue())) { //审核通过
                allocationRequest.setApplyStatus(GeneralEnum.AllocationApproveStatus.OUT_CONFIRM.getValue()); //调拨申请状态 待调出方确认
                allocationSchedule.setItem(GeneralEnum.AllocationScheduleItem.HEADER_PASS.getValue()); //调拨进度事项
            } else if (Objects.equals(param.getApproveResult(), GeneralEnum.ApproveResult.REFUSE.getValue())) { //审核拒绝
                allocationRequest.setApplyStatus(GeneralEnum.AllocationApproveStatus.HEADER_REFUSE.getValue()); //调拨申请状态 总部拒绝
                allocationRequest.setInHandleRemark(param.getRemark()); //备注信息
                allocationSchedule.setItem(GeneralEnum.AllocationScheduleItem.HEADER_REFUSE.getValue()); //调拨进度事项
            } else if (Objects.equals(param.getApproveResult(), GeneralEnum.ApproveResult.RETURN.getValue())) { //审核退回
                allocationRequest.setApplyStatus(GeneralEnum.AllocationApproveStatus.HEADER_RETURN.getValue()); //调拨申请状态 总部退回
                allocationRequest.setInHandleRemark(param.getRemark()); //备注信息
                allocationSchedule.setItem(GeneralEnum.AllocationScheduleItem.HEADER_RETURN.getValue()); //调拨进度事项
            } else {
                throw new GeneralException("传参有误");
            }
        } else if (Objects.equals(param.getType(), 2)) { //调出方确认
            if (Objects.equals(allocationRequest.getOutHandleStatus(), GeneralEnum.ProcessingStatus.PROCESSED.getValue())) {
                throw new GeneralException("调出方已处理");
            }
            allocationRequest.setOutHandleStatus(GeneralEnum.ProcessingStatus.PROCESSED.getValue()); //总部处理结果
            allocationRequest.setOutHandler(user.getId()); //总部审批人
            allocationRequest.setOutHandleTime(ZWDateUtil.getNowDateTime()); //总部审批时间
            if (Objects.equals(param.getApproveResult(), GeneralEnum.ApproveResult.PASS.getValue())) { //审核通过
                allocationRequest.setApplyStatus(GeneralEnum.AllocationApproveStatus.OUTBOUND.getValue()); //调拨申请状态 待出库
                allocationSchedule.setItem(GeneralEnum.AllocationScheduleItem.OUT_PASS.getValue()); //调拨进度事项

                //调出方确认通过之后生成调拨出库记录
                AllocationVehicle example = new AllocationVehicle();
                example.setAllocationRequestId(param.getId());
                List<AllocationVehicle> list = allocationVehicleService.findListByWhere(example);
                if (list.isEmpty()) {
                    throw new GeneralException("调拨车辆信息未找到");
                }
                for (AllocationVehicle allocationVehicle : list) {
                    AllocationRecord allocationRecord = new AllocationRecord();
                    allocationRecord.setVehicleId(allocationVehicle.getVehicleId()); //车辆ID
                    allocationRecord.setAllocationOrderId(param.getId()); //调拨申请ID
                    allocationRecord.setHandleStatus(GeneralEnum.ProcessingStatus.UNPROCESSED.getValue()); //处理状态
                    allocationRecord.setType(GeneralEnum.AllocationType.ALLOCATION_OUT.getValue()); //调拨类型
                    allocationRecord.setApplyTime(ZWDateUtil.getNowDateTime()); //申请时间
                    allocationRecord.setUpdater(user.getId()); //最后操作人
                    allocationRecord.setUpdateTime(ZWDateUtil.getNowDateTime()); //最后操作时间
                    allocationRecordService.save(allocationRecord);
                }
            } else if (Objects.equals(param.getApproveResult(), GeneralEnum.ApproveResult.REFUSE.getValue())) { //审核拒绝
                allocationRequest.setApplyStatus(GeneralEnum.AllocationApproveStatus.OUT_REFUSE.getValue()); //调拨申请状态 调出方拒绝
                allocationSchedule.setItem(GeneralEnum.AllocationScheduleItem.OUT_REFUSE.getValue()); //调拨进度事项
                allocationRequest.setInHandleRemark(param.getRemark()); //备注信息
            } else if (Objects.equals(param.getApproveResult(), GeneralEnum.ApproveResult.RETURN.getValue())) { //审核退回
                allocationRequest.setApplyStatus(GeneralEnum.AllocationApproveStatus.OUT_RETURN.getValue()); //调拨申请状态 调出方退回
                allocationRequest.setInHandleRemark(param.getRemark()); //备注信息
                allocationSchedule.setItem(GeneralEnum.AllocationScheduleItem.OUT_RETURN.getValue()); //调拨进度事项
            } else {
                throw new GeneralException("传参有误");
            }
        }
        allocationRequest.setUpdater(user.getId()); //最后操作人
        allocationRequest.setUpdateTime(ZWDateUtil.getNowDateTime()); //最后操作时间
        update(allocationRequest);
        allocationScheduleService.save(allocationSchedule);
    }
}
