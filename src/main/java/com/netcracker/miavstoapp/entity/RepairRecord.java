package com.netcracker.miavstoapp.entity;


import javax.persistence.*;

@Entity
@Table(name = " repair_record")
public class RepairRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "repair_record_description")
    private String repairRecordDescription;
    @Column(name = "detail_price")
    private String detailPrice;
    @Column(name = "work_price")
    private String workPrice;
    @Column(name = "other_notes")
    private String otherNotes;

    @OneToOne(cascade = {CascadeType.REFRESH, CascadeType.MERGE})
    @JoinColumn(name = "repair_request_id")
    private RepairRequest repairRequest;

    public RepairRecord() {
    }

    public RepairRecord(String repairRecordDescription, String detailPrice, String workPrice, String otherNotes) {
        this.repairRecordDescription = repairRecordDescription;
        this.detailPrice = detailPrice;
        this.workPrice = workPrice;
        this.otherNotes = otherNotes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRepairRecordDescription() {
        return repairRecordDescription;
    }

    public void setRepairRecordDescription(String repairRecordDescription) {
        this.repairRecordDescription = repairRecordDescription;
    }

    public String getDetailPrice() {
        return detailPrice;
    }

    public void setDetailPrice(String detailPrice) {
        this.detailPrice = detailPrice;
    }

    public String getWorkPrice() {
        return workPrice;
    }

    public void setWorkPrice(String workPrice) {
        this.workPrice = workPrice;
    }

    public String getOtherNotes() {
        return otherNotes;
    }

    public void setOtherNotes(String otherNotes) {
        this.otherNotes = otherNotes;
    }

    public RepairRequest getRepairRequest() {
        return repairRequest;
    }

    public void setRepairRequest(RepairRequest repairRequest) {
        this.repairRequest = repairRequest;
    }

    @Override
    public String toString() {
        return "RepairRecord{" +
                "id=" + id +
                ", repairRecordDescription='" + repairRecordDescription + '\'' +
                ", detailPrice='" + detailPrice + '\'' +
                ", workPrice='" + workPrice + '\'' +
                ", otherNotes='" + otherNotes + '\'' +
                ", repairRequest=" + repairRequest +
                '}';
    }
}
