package com.rms.Order.entity;

import lombok.*;

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
public class Vdc {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String vdcName;
    private String description;
    private String vimZoneName;
    private String vdcRequestid;
    private String orderRequestid;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVdcName() {
        return vdcName;
    }

    public void setVdcName(String vdcName) {
        this.vdcName = vdcName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVimZoneName() {
        return vimZoneName;
    }

    public void setVimZoneName(String vimZoneName) {
        this.vimZoneName = vimZoneName;
    }

    public String getVdcRequestid() {
        return vdcRequestid;
    }

    public void setVdcRequestid(String vdcRequestid) {
        this.vdcRequestid = vdcRequestid;
    }
}
