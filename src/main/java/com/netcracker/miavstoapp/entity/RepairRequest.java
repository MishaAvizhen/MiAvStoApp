package com.netcracker.miavstoapp.entity;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "repair_request")
public class RepairRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "date_of_repair")
    private Date dateOfRequest;
    @Column(name = "status")
    private String status;
    @Column(name = "car_remark")
    private String carRemark;
    @Column(name = "repair_request_description")
    private String repairRequestDescription;

    @OneToOne(cascade = {CascadeType.REFRESH, CascadeType.MERGE}, mappedBy = "repairRequest", fetch = FetchType.EAGER)
    private RepairRecord repairRecord;

    @ManyToOne(cascade = {CascadeType.REFRESH, CascadeType.MERGE})
    @JoinColumn(name = "user_id")
    private User user;

    public RepairRequest() {
    }

    public RepairRequest(Date dateOfRequest, String repairRequestDescription, String carRemark, String status) {
        this.dateOfRequest = dateOfRequest;
        this.repairRequestDescription = repairRequestDescription;
        this.carRemark = carRemark;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateOfRequest() {
        return dateOfRequest;
    }

    public void setDateOfRequest(Date dateOfRequest) {
        this.dateOfRequest = dateOfRequest;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public RepairRecord getRepairRecord() {
        return repairRecord;
    }

    public void setRepairRecord(RepairRecord repairRecord) {
        this.repairRecord = repairRecord;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "RepairRequest{" +
                "id=" + id +
                ", dateOfRequest=" + dateOfRequest +
                ", status='" + status + '\'' +
                ", carRemark='" + carRemark + '\'' +
                ", repairRequestDescription='" + repairRequestDescription + '\'' +
                ", repairRecord=" + repairRecord +
                ", user=" + user +
                '}';
    }
}

