package ru.dom.lukmanovcarhiring.app.dao.entity;

import ru.dom.lukmanovcarhiring.common.dao.entity.CommonEntity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "RESERVATION")
public class ReservationEntity extends CommonEntity {

    @Column(name = "D_PICKUP_DATE")
    @Temporal(TemporalType.DATE)
    private Date pickupDate;

    @Column(name = "D_RETURN_DATE")
    @Temporal(TemporalType.DATE)
    private Date returnDate;

    @Column(name = "I_PICKUP_LOCATION_ID")
    private Long pickupLocationId;

    @Column(name = "I_RETURN_LOCATION_ID")
    private Long returnLocationId;

    @Column(name = "I_USER_ID")
    private Long userId;

    @Column(name = "I_CAR_ID")
    private Long carId;

    public Date getPickupDate() {
        return pickupDate;
    }

    public void setPickupDate(Date pickupDate) {
        this.pickupDate = pickupDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public Long getPickupLocationId() {
        return pickupLocationId;
    }

    public void setPickupLocationId(Long pickupLocationId) {
        this.pickupLocationId = pickupLocationId;
    }

    public Long getReturnLocationId() {
        return returnLocationId;
    }

    public void setReturnLocationId(Long returnLocationId) {
        this.returnLocationId = returnLocationId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }
}

/*

i_id int not null auto_increment,
    d_pickup_date date,
    d_return_date date,
    i_pickup_location_id int default null,
    i_return_location_id int default null,
    i_user_id int default null,
    i_car_id int default null,*/
