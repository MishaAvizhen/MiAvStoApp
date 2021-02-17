package com.netcracker.miavstoapp.service.impl;


import com.netcracker.miavstoapp.constants.RepairRequestConstants;
import com.netcracker.miavstoapp.dao.RepairRecordDao;
import com.netcracker.miavstoapp.dao.RepairRequestDao;
import com.netcracker.miavstoapp.dto.RepairRecordDto;
import com.netcracker.miavstoapp.entity.RepairRecord;
import com.netcracker.miavstoapp.entity.RepairRequest;
import com.netcracker.miavstoapp.service.RepairRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RepairRecordServiceImpl implements RepairRecordService {
    @Autowired
    private RepairRecordDao repairRecordDao;
    @Autowired
    private RepairRequestDao repairRequestDao;

    @Transactional
    @Override
    public RepairRecord addRepairRecord(RepairRecordDto repairRecordDto) {
        RepairRequest repairRequest = repairRequestDao.findOne(repairRecordDto.getRepairRequestId());
        if (repairRequest == null) {
            throw new RuntimeException("Requested repair request not exists.");
        }
        RepairRecord existingRepairRecord = repairRequest.getRepairRecord();
        if (existingRepairRecord == null) {
            RepairRecord repairRecord = new RepairRecord();
            repairRecord.setRepairRecordDescription(repairRecordDto.getRepairRecordDescription());
            repairRecord.setDetailPrice(repairRecordDto.getDetailPrice());
            repairRecord.setWorkPrice(repairRecordDto.getWorkPrice());
            repairRecord.setOtherNotes(repairRecordDto.getOtherNotes());
            repairRecord.setRepairRequest(repairRequest);
            repairRequest.setStatus(RepairRequestConstants.STATUS_PROCESSED);
            repairRequestDao.save(repairRequest);
            return repairRecordDao.save(repairRecord);
        } else {
            return existingRepairRecord;
        }


    }

}
