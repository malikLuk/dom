package ru.dom.lukmanovcarhiring.app.dto;

import ru.dom.lukmanovcarhiring.app.dao.entity.CarHiringStatus;
import ru.dom.lukmanovcarhiring.common.dto.CommonDto;

public class CarDto extends CommonDto {

    private String name;

    private CarHiringStatus status;

    private Long currentLocationid;

    public Long getCurrentLocationid() {
        return currentLocationid;
    }

    public void setCurrentLocationid(Long currentLocationid) {
        this.currentLocationid = currentLocationid;
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
