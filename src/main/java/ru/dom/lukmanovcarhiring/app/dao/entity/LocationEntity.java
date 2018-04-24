package ru.dom.lukmanovcarhiring.app.dao.entity;

import ru.dom.lukmanovcarhiring.common.dao.entity.CommonEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "LOCATION")
public class LocationEntity extends CommonEntity {

    @Column(name = "S_ADDRESS")
    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
