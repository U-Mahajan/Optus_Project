package com.rms.Order.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Ecm {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String vdcName;
    private String orderRequestid;
    private String ECMRequestid;
    private String ECMRequestType;
    private String ECMRequest;

    public String getOrderRequestid() {
        return orderRequestid;
    }

    public void setOrderRequestid(String orderRequestid) {
        this.orderRequestid = orderRequestid;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getVdcName() {
        return vdcName;
    }

    public void setVdcName(String vdcName) {
        this.vdcName = vdcName;
    }

    public String getECMRequestid() {
        return ECMRequestid;
    }

    public void setECMRequestid(String ECMRequestid) {
        this.ECMRequestid = ECMRequestid;
    }

    public String getECMRequestType() {
        return ECMRequestType;
    }

    public void setECMRequestType(String ECMRequestType) {
        this.ECMRequestType = ECMRequestType;
    }

    public String getECMRequest() {
        return ECMRequest;
    }

    public void setECMRequest(String ECMRequest) {
        this.ECMRequest = ECMRequest;
    }
}
