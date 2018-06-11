package com.fintecher.sims.service.impl;

import com.fintecher.sims.entity.*;
import com.fintecher.sims.exception.GeneralException;
import com.fintecher.sims.mapper.AllocationRecordMapper;
import com.fintecher.sims.service.*;
import com.fintecher.sims.util.GeneralEnum;
import com.fintecher.sims.util.ZWDateUtil;
import com.fintecher.sims.vo.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

/**
 * @System: 进销存
 * @Auther: xiaqun
 * @Description:
 * @Date: Created on 2018/3/14 11:04
 * @Modified By:
 */

@Service
@Transactional(rollbackFor = Exception.class)
public class AllocationRecordServiceImpl extends BaseServiceImpl<AllocationRecord> implements AllocationRecordService {
    @Autowired
    private AllocationRecordMapper allocationRecordMapper;

    @Autowired
    private VehicleService vehicleService;

    @Autowired
    private AllocationRequestService allocationRequestService;

    @Autowired
    private VehicleMileageRecordService vehicleMileageRecordService;

    @Autowired
    private AllocationScheduleService allocationScheduleService;

    @Autowired
    private MeasuresRecordService measuresRecordService;

    /**
     * @System: 进销存
     * @Auther: xiaqun
     * @Description: 多条件查询调拨出库记录
     * @Modified By:
     */
    @Override
    public List<AllocationRecordModel> getOutAllocationRecord(AllocationRecordParam param) throws Exception {
        String flag = Objects.equals(param.getFlag(), 0) ? null : GeneralEnum.ProcessingStatus.PROCESSED.getValue().toString();
        return allocationRecordMapper.getAllAllocationRecord(StringUtils.trim(param.getKeyword()), flag, GeneralEnum.AllocationType.ALLOCATION_OUT.getValue().toString());
    }

    /**
     * @System: 进销存
     * @Auther: xiaqun
     * @Description: 调拨出库
     * @Modified By:
     */
    @Override
    public void allocationOut(AllocationRecordOutParam param, UserModel user) throws Exception {
        AllocationRecord allocationRecord = findById(param.getAllocationRecordId());
        if (Objects.isNull(allocationRecord)) {
            throw new GeneralException("调拨出库记录未找到");
        }
        Vehicle vehicle = vehicleService.findById(allocationRecord.getVehicleId());
        if (Objects.isNull(vehicle)) {
            throw new GeneralException("车辆信息未找到");
        }
        AllocationRequest allocationRequest = allocationRequestService.findById(allocationRecord.getAllocationOrderId());
        if (Objects.isNull(allocationRequest)) {
            throw new GeneralException("调拨申请单信息未找到");
        }
        //TODO 验证必传素材

        //更新车辆信息
        if (Objects.nonNull(param.getSubjection())) {
            vehicle.setSubjection(param.getSubjection()); //车辆隶属
        }
        if (Objects.nonNull(param.getPlateDate())) {
            vehicle.setPlateDate(param.getPlateDate()); //上牌日期
        }
        if (Objects.nonNull(param.getPlateNumber())) {
            vehicle.setPlateNumber(param.getPlateNumber()); //车牌号
        }
        vehicle.setVehicleCondition(param.getCondition()); //车况
        if (Objects.nonNull(param.getAbnormalExplain())) {
            vehicle.setAbnormalExplain(param.getAbnormalExplain()); //车况描述
        }
        vehicle.setOdometerNumber(param.getOdometerNumber()); //里程表值
        vehicle.setGpsStatus(param.getGpsStatus()); //GPS状态
        vehicle.setUpdater(user.getId()); //最后操作人
        vehicle.setUpdateTime(ZWDateUtil.getNowDateTime()); //最后操作时间
        vehicleService.update(vehicle);

        //更新调拨出入库记录
        allocationRecord.setDescription(param.getDescription()); //情况描述
        allocationRecord.setHandleStatus(GeneralEnum.ProcessingStatus.PROCESSED.getValue()); //处理状态
        allocationRecord.setHandler(user.getId()); //处理人
        allocationRecord.setHandleTime(ZWDateUtil.getNowDateTime()); //处理时间
        allocationRecord.setStorageTime(param.getOutTime()); //出库时间
        allocationRecord.setUpdater(user.getId()); //最后操作人
        allocationRecord.setUpdateTime(ZWDateUtil.getNowDateTime()); //最后操作时间
        update(allocationRecord);

        //更新调拨申请
        AllocationRecord record = new AllocationRecord();
        record.setAllocationOrderId(allocationRecord.getAllocationOrderId());
        record.setType(GeneralEnum.AllocationType.ALLOCATION_OUT.getValue());
        List<AllocationRecord> list = findListByWhere(record);
        if (list.isEmpty()) {
            throw new GeneralException("调拨申请记录未找到");
        } else {
            Boolean flag = true;
            for (AllocationRecord result : list) {
                if (Objects.equals(result.getHandleStatus(), GeneralEnum.ProcessingStatus.UNPROCESSED.getValue())) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                allocationRequest.setApplyStatus(GeneralEnum.AllocationApproveStatus.STORAGE.getValue()); //申请状态 待入库
                allocationRequest.setUpdater(user.getId()); //最后操作人
                allocationRequest.setUpdateTime(ZWDateUtil.getNowDateTime()); //最后操作时间
                allocationRequestService.update(allocationRequest);
            }

            //生成调拨记录
            AllocationSchedule allocationSchedule = new AllocationSchedule();
            allocationSchedule.setAllocationRequestId(allocationRecord.getAllocationOrderId()); //调拨申请
            allocationSchedule.setItem(GeneralEnum.AllocationScheduleItem.OUTBOUND.getValue()); //事项
            allocationSchedule.setOperator(user.getId()); //操作人
            allocationSchedule.setOperateTime(ZWDateUtil.getNowDateTime()); //操作时间
            allocationScheduleService.save(allocationSchedule);
        }

        //生成入库记录
        AllocationRecord result = new AllocationRecord();
        result.setType(GeneralEnum.AllocationType.ALLOCATION_IN.getValue()); //入库类型 调拨入库
        result.setApplyTime(ZWDateUtil.getNowDateTime()); //申请时间
        result.setHandleStatus(GeneralEnum.ProcessingStatus.UNPROCESSED.getValue()); //处理状态
        result.setAllocationOrderId(allocationRecord.getAllocationOrderId()); //调拨申请ID
        result.setVehicleId(allocationRecord.getVehicleId()); //车辆ID
        result.setDescription(allocationRecord.getDescription()); //情况描述
        result.setUpdater(user.getId()); //最后操作人
        result.setUpdateTime(ZWDateUtil.getNowDateTime()); //最后操作时间
        save(result);

        //生成车辆里程记录
        VehicleMileageRecord vehicleMileageRecord = new VehicleMileageRecord();
        vehicleMileageRecord.setVehicleId(allocationRecord.getVehicleId()); //车辆ID
        vehicleMileageRecord.setType(GeneralEnum.VehicleMileageType.ALLOCATION.getValue()); //类型 调拨
        vehicleMileageRecord.setStorageType(GeneralEnum.VehicleMileageStorage.OUT.getValue()); //出入类型 出库
        vehicleMileageRecord.setOrderNumber(allocationRequest.getAllocationOrderNumber()); //对应单号
        vehicleMileageRecord.setOdometerNumber(param.getOdometerNumber()); //里程数
        vehicleMileageRecord.setParkCompanyId(allocationRequest.getOutCompanyId()); //当前所在仓库
        vehicleMileageRecord.setOperator(user.getId()); //创建人
        vehicleMileageRecord.setOperateTime(ZWDateUtil.getNowDateTime()); //创建时间
        vehicleMileageRecordService.save(vehicleMileageRecord);
    }

    /**
     * @System: 进销存
     * @Auther: xiaqun
     * @Description: 多条件查询调拨入库记录
     * @Modified By:
     */
    @Override
    public List<AllocationRecordModel> getInAllocationRecord(AllocationRecordParam param) throws Exception {
        String flag = Objects.equals(param.getFlag(), 0) ? null : GeneralEnum.ProcessingStatus.PROCESSED.getValue().toString();
        return allocationRecordMapper.getAllAllocationRecord(StringUtils.trim(param.getKeyword()), flag, GeneralEnum.AllocationType.ALLOCATION_IN.getValue().toString());
    }

    /**
     * @System: 进销存
     * @Auther: xiaqun
     * @Description: 调拨入库
     * @Modified By:
     */
    @Override
    public void allocationIn(AllocationRecordInParam param, UserModel user) throws Exception {
        AllocationRecord allocationRecord = findById(param.getAllocationRecordId());
        if (Objects.isNull(allocationRecord)) {
            throw new GeneralException("调拨出库记录未找到");
        }
        Vehicle vehicle = vehicleService.findById(allocationRecord.getVehicleId());
        if (Objects.isNull(vehicle)) {
            throw new GeneralException("车辆信息未找到");
        }
        AllocationRequest allocationRequest = allocationRequestService.findById(allocationRecord.getAllocationOrderId());
        if (Objects.isNull(allocationRequest)) {
            throw new GeneralException("调拨申请单信息未找到");
        }
        //TODO 验证必传素材

        //更新车辆信息
        if (Objects.nonNull(param.getSubjection())) {
            vehicle.setSubjection(param.getSubjection()); //车辆隶属
        }
        if (Objects.nonNull(param.getPlateDate())) {
            vehicle.setPlateDate(param.getPlateDate()); //上牌日期
        }
        if (Objects.nonNull(param.getPlateNumber())) {
            vehicle.setPlateNumber(param.getPlateNumber()); //车牌号
        }
        vehicle.setVehicleCondition(param.getCondition()); //车况
        if (Objects.nonNull(param.getAbnormalExplain())) {
            vehicle.setAbnormalExplain(param.getAbnormalExplain()); //车况描述
        }
        vehicle.setOdometerNumber(param.getOdometerNumber()); //里程表值
        vehicle.setGpsStatus(param.getGpsStatus()); //GPS状态
        if (Objects.nonNull(param.getEmissionStandard())) {
            vehicle.setEmissionStandard(param.getEmissionStandard()); //排放标准
        }
        vehicle.setParkStatus(param.getParkStatus()); //停放状态
        vehicle.setUpdater(user.getId()); //最后操作人
        vehicle.setUpdateTime(ZWDateUtil.getNowDateTime()); //最后操作时间
        vehicleService.update(vehicle);

        //更新调拨出入库记录
        allocationRecord.setDescription(param.getDescription()); //情况描述
        allocationRecord.setHandleStatus(GeneralEnum.ProcessingStatus.PROCESSED.getValue()); //处理状态
        allocationRecord.setHandler(user.getId()); //处理人
        allocationRecord.setHandleTime(ZWDateUtil.getNowDateTime()); //处理时间
        allocationRecord.setStorageTime(param.getInTime()); //入库时间
        allocationRecord.setUpdater(user.getId()); //最后操作人
        allocationRecord.setUpdateTime(ZWDateUtil.getNowDateTime()); //最后操作时间
        update(allocationRecord);

        //更新调拨申请
        AllocationRecord record = new AllocationRecord();
        record.setAllocationOrderId(allocationRecord.getAllocationOrderId());
        record.setType(GeneralEnum.AllocationType.ALLOCATION_IN.getValue());
        List<AllocationRecord> list = findListByWhere(record);
        if (list.isEmpty()) {
            throw new GeneralException("调拨申请记录未找到");
        } else {
            Boolean flag = true;
            for (AllocationRecord result : list) {
                if (Objects.equals(result.getHandleStatus(), GeneralEnum.ProcessingStatus.UNPROCESSED.getValue())) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                allocationRequest.setApplyStatus(GeneralEnum.AllocationApproveStatus.COMPLETE.getValue()); //申请状态 已入库
                allocationRequest.setUpdater(user.getId()); //最后操作人
                allocationRequest.setUpdateTime(ZWDateUtil.getNowDateTime()); //最后操作时间
                allocationRequestService.update(allocationRequest);
            }

            //生成调拨记录
            AllocationSchedule allocationSchedule = new AllocationSchedule();
            allocationSchedule.setAllocationRequestId(allocationRecord.getAllocationOrderId()); //调拨申请
            allocationSchedule.setItem(GeneralEnum.AllocationScheduleItem.STORAGE.getValue()); //事项
            allocationSchedule.setOperator(user.getId()); //操作人
            allocationSchedule.setOperateTime(ZWDateUtil.getNowDateTime()); //操作时间
            allocationScheduleService.save(allocationSchedule);
        }

        //生成车辆里程记录
        VehicleMileageRecord vehicleMileageRecord = new VehicleMileageRecord();
        vehicleMileageRecord.setVehicleId(allocationRecord.getVehicleId()); //车辆ID
        vehicleMileageRecord.setType(GeneralEnum.VehicleMileageType.ALLOCATION.getValue()); //类型 调拨
        vehicleMileageRecord.setStorageType(GeneralEnum.VehicleMileageStorage.IN.getValue()); //出入类型 出库
        vehicleMileageRecord.setOrderNumber(allocationRequest.getAllocationOrderNumber()); //对应单号
        vehicleMileageRecord.setOdometerNumber(param.getOdometerNumber()); //里程数
        vehicleMileageRecord.setParkCompanyId(allocationRequest.getInCompanyId()); //当前所在仓库
        vehicleMileageRecord.setOperator(user.getId()); //创建人
        vehicleMileageRecord.setOperateTime(ZWDateUtil.getNowDateTime()); //创建时间
        vehicleMileageRecordService.save(vehicleMileageRecord);

        //保存库放措施记录
        MeasuresRecord measuresRecord = new MeasuresRecord();
        measuresRecord.setVehicleId(vehicle.getId()); //车辆ID
        measuresRecord.setOdometerNumber(param.getOdometerNumber()); //里程表数
        measuresRecord.setStorageStatus(param.getParkStatus()); //停放状态
        measuresRecord.setContent(param.getContent()); //措施内容
        measuresRecord.setDescription(param.getDescription()); //情况描述
        measuresRecord.setOperator(user.getId()); //创建人
        measuresRecord.setOperateTime(ZWDateUtil.getNowDateTime()); //创建时间
        measuresRecord.setUpdater(user.getId()); //最后操作人
        measuresRecord.setUpdateTime(ZWDateUtil.getNowDateTime()); //最后操作时间
        measuresRecordService.save(measuresRecord);
    }
}
