package ru.dom.lukmanovcarhiring.app.params;

import ru.dom.lukmanovcarhiring.common.params.CommonParams;

public class CarParams extends CommonParams {

    private String name;
    private Long currentLocationId;

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
}
