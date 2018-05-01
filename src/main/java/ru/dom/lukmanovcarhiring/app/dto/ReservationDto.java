package ru.dom.lukmanovcarhiring.app.dto;

import ru.dom.lukmanovcarhiring.common.dto.CommonDto;

import java.util.Date;

public class ReservationDto extends CommonDto {

    private Date pickupDate;

    private Date returnDate;

    private Long pickupLocationId;

    private Long returnLocationId;

    private Long userId;

    private Long carId;

    private String locationAddress;

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

    public String getLocationAddress() {
        return locationAddress;
    }

    public void setLocationAddress(String locationAddress) {
        this.locationAddress = locationAddress;
    }
}
