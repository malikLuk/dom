package ru.dom.lukmanovcarhiring.app.dao.entity;

import ru.dom.lukmanovcarhiring.common.dao.entity.CommonEntity;

import javax.persistence.*;

@Entity
@Table(name = "CAR")
public class CarEntity extends CommonEntity {

    @Column(name = "S_NAME")
    private String name;

    @Column(name = "I_STATUS")
    @Enumerated(EnumType.ORDINAL)
    private CarHiringStatus status;

    @Column(name = "I_CURRENT_LOCATION_ID")
    private Long currentLocationId;

    @Column(name = "I_CURRENT_OWNER_ID")
    private Long currentOwnerId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CarHiringStatus getStatus() {
        return status;
    }

    public void setStatus(CarHiringStatus status) {
        this.status = status;
    }

    public Long getCurrentLocationId() {
        return currentLocationId;
    }

    public void setCurrentLocationId(Long currentLocationId) {
        this.currentLocationId = currentLocationId;
    }

    public Long getCurrentOwnerId() {
        return currentOwnerId;
    }

    public void setCurrentOwnerId(Long currentOwnerId) {
        this.currentOwnerId = currentOwnerId;
    }
}
