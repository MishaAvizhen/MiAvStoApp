package com.netcracker.miavstoapp.dto;


public class RepairRecordDto {
    private Long repairRequestId;
    private String repairRecordDescription;
    private String detailPrice;
    private String workPrice;
    private String otherNotes;

    public RepairRecordDto() {
    }

    public String getOtherNotes() {
        return otherNotes;
    }

    public Long getRepairRequestId() {
        return repairRequestId;
    }

    public void setRepairRequestId(Long repairRequestId) {
        this.repairRequestId = repairRequestId;
    }

    public void setOtherNotes(String otherNotes) {
        this.otherNotes = otherNotes;
    }

    public String getWorkPrice() {
        return workPrice;
    }

    public void setWorkPrice(String workPrice) {
        this.workPrice = workPrice;
    }

    public String getDetailPrice() {
        return detailPrice;
    }

    public void setDetailPrice(String detailPrice) {
        this.detailPrice = detailPrice;
    }

    public String getRepairRecordDescription() {
        return repairRecordDescription;
    }

    public void setRepairRecordDescription(String repairRecordDescription) {
        this.repairRecordDescription = repairRecordDescription;
    }
}
