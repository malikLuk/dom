package ru.dom.lukmanovcarhiring.app.dto;

import ru.dom.lukmanovcarhiring.app.dao.entity.CarHiringStatus;
import ru.dom.lukmanovcarhiring.common.dto.CommonDto;

public class CarDto extends CommonDto {

    private String name;

    private CarHiringStatus status;

    private Long currentLocationId;

    public Long getCurrentLocationId() {
        return currentLocationId;
    }

    public void setCurrentLocationId(Long currentLocationId) {
        this.currentLocationId = currentLocationId;
    }

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
}
