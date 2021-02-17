package com.netcracker.miavstoapp.service;


import com.netcracker.miavstoapp.dto.RepairRecordDto;
import com.netcracker.miavstoapp.entity.RepairRecord;

public interface RepairRecordService {
    RepairRecord addRepairRecord(RepairRecordDto repairRecordDto);

}
