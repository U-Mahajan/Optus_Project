package com.rms.Order.entity;

import lombok.*;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String vdcRequestid;
    private String orderHandlerid;
    private String orderRequestid;
    private String designVdc;
    private String activationVdc;
    private String orderComplete;
    private String finishOrder;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getVdcRequestid() {
        return vdcRequestid;
    }

    public void setVdcRequestid(String vdcRequestid) {
        this.vdcRequestid = vdcRequestid;
    }

    public String getOrderHandlerid() {
        return orderHandlerid;
    }

    public void setOrderHandlerid(String orderHandlerid) {
        this.orderHandlerid = orderHandlerid;
    }

    public String getOrderRequestid() {
        return orderRequestid;
    }

    public void setOrderRequestid(String orderRequestid) {
        this.orderRequestid = orderRequestid;
    }

    public String getDesignVdc() {
        return designVdc;
    }

    public void setDesignVdc(String designVdc) {
        this.designVdc = designVdc;
    }

    public String getActivationVdc() {
        return activationVdc;
    }

    public void setActivationVdc(String activationVdc) {
        this.activationVdc = activationVdc;
    }

    public String getOrderComplete() {
        return orderComplete;
    }

    public void setOrderComplete(String orderComplete) {
        this.orderComplete = orderComplete;
    }

    public String getFinishOrder() {
        return finishOrder;
    }

    public void setFinishOrder(String finishOrder) {
        this.finishOrder = finishOrder;
    }
}

