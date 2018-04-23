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

    @Column(name = "I_ID_RENTER")
    private Long idRenter;

    public Long getIdRenter() {
        return idRenter;
    }

    public void setIdRenter(Long idRenter) {
        this.idRenter = idRenter;
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
