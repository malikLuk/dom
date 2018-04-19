package ru.dom.lukmanovcarhiring.dto;

import ru.dom.lukmanovcarhiring.common.dto.CommonDto;

public class CarsDto extends CommonDto {

    private String name;

    private Boolean inUse;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getInUse() {
        return inUse;
    }

    public void setInUse(Boolean inUse) {
        this.inUse = inUse;
    }

}