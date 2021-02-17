package com.netcracker.miavstoapp.controller.rest;

import com.netcracker.miavstoapp.dao.RepairRecordDao;
import com.netcracker.miavstoapp.dto.RepairRecordDto;
import com.netcracker.miavstoapp.entity.RepairRecord;
import com.netcracker.miavstoapp.service.RepairRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class RepairRecordRestController {
    @Autowired
    private RepairRecordDao repairRecordDao;
    @Autowired
    private RepairRecordService repairRecordService;

    @RequestMapping(value = "/addRepairRecord", method = RequestMethod.POST)
    public ResponseEntity addRepairRecordItem( @RequestBody RepairRecordDto repairRecordDto) {
        RepairRecord addedRepairRecord = repairRecordService.addRepairRecord(repairRecordDto);
        return new ResponseEntity<RepairRecord>(addedRepairRecord, HttpStatus.OK);
    }
}
