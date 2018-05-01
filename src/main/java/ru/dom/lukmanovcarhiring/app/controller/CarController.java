package ru.dom.lukmanovcarhiring.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.dom.lukmanovcarhiring.app.dao.entity.CarEntity;
import ru.dom.lukmanovcarhiring.app.dto.CarDto;
import ru.dom.lukmanovcarhiring.app.params.CarParams;
import ru.dom.lukmanovcarhiring.app.service.CarService;
import ru.dom.lukmanovcarhiring.app.service.ReservationService;
import ru.dom.lukmanovcarhiring.common.controller.CommonController;
import ru.dom.lukmanovcarhiring.common.service.CommonService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("car_hiring/car")
public class CarController extends CommonController<CarParams, CarEntity, CarDto> {

    @Autowired
    private final CarService carService;

    @Autowired
    private final ReservationService reservationService;

    @Autowired
    public CarController(CarService service, ReservationService reservationService) {
        this.carService = service;
        this.reservationService = reservationService;
    }

    @Override
    public CommonService<CarParams, CarEntity, CarDto> getService() {
        return carService;
    }

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CarDto>> getCars(Map<String, Object> model, @RequestBody CarParams params) {
        List<CarDto> list =  this.filter(model, params);
        return new ResponseEntity<List<CarDto>>(list, HttpStatus.OK);
    }

    @RequestMapping(value = "/update_status", method = RequestMethod.POST,
        produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CarDto> reserve(Map<String, Object> model, @RequestBody CarParams params) {
        return new ResponseEntity<CarDto>(this.updateStatus(params), HttpStatus.OK);
    }

}
