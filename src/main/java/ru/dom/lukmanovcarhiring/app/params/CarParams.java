package ru.dom.lukmanovcarhiring.app.params;

import ru.dom.lukmanovcarhiring.app.dao.entity.CarHiringStatus;
import ru.dom.lukmanovcarhiring.common.params.CommonParams;

public class CarParams extends CommonParams {

    private String name;
    private Long currentLocationId;
    private CarHiringStatus status;
    private Long currentOwnerId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public CarHiringStatus getStatus() {
        return status;
    }

    public void setStatus(CarHiringStatus status) {
        this.status = status;
    }
}
