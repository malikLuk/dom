package ru.dom.lukmanovcarhiring.app.dto;

import ru.dom.lukmanovcarhiring.common.dto.CommonDto;

public class LocationDto extends CommonDto {

    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
