package com.netcracker.miavstoapp.dto;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


public class RepairRequestDto {
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateOfRequest;
    private String carRemark;
    private String repairRequestDescription;

    public RepairRequestDto() {
    }

    public Date getDateOfRequest() {
        return dateOfRequest;
    }

    public void setDateOfRequest(Date dateOfRequest) {
        this.dateOfRequest = dateOfRequest;
    }

    public String getCarRemark() {
        return carRemark;
    }

    public void setCarRemark(String carRemark) {
        this.carRemark = carRemark;
    }

    public String getRepairRequestDescription() {
        return repairRequestDescription;
    }

    public void setRepairRequestDescription(String repairRequestDescription) {
        this.repairRequestDescription = repairRequestDescription;
    }
}
