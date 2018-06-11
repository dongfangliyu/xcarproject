package com.fintecher.sims.mapper;

import com.fintecher.sims.entity.VehicleMileageRecord;
import com.fintecher.sims.util.MyMapper;
import com.fintecher.sims.vo.VehicleMileageRecordModel;

import java.util.List;

/**
 * @System: 进销存
 * @Auther: lijian
 * @Description: 车辆里程记录
 * @Date: Created on 2018/3/14 14:18
 * @Modified_By:
 */

public interface VehicleMileageRecordMapper extends MyMapper<VehicleMileageRecord> {

    /**
     * @System: 进销存
     * @Auther: lijian
     * @Description: 根据车辆ID获取车辆的里程记录
     * @Date: Created on 2018/3/14 14:48
     * @Modified_By:
     */

    List<VehicleMileageRecordModel> queryVehicleMileageRecord(Long vehiId);
}
