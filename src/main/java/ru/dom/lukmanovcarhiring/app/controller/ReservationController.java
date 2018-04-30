package ru.dom.lukmanovcarhiring.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.dom.lukmanovcarhiring.app.dao.entity.ReservationEntity;
import ru.dom.lukmanovcarhiring.app.dto.CarDto;
import ru.dom.lukmanovcarhiring.app.dto.ReservationDto;
import ru.dom.lukmanovcarhiring.app.params.ReservationParams;
import ru.dom.lukmanovcarhiring.app.service.ReservationService;
import ru.dom.lukmanovcarhiring.common.controller.CommonController;
import ru.dom.lukmanovcarhiring.common.service.CommonService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/car_hiring/user_cars")
public class ReservationController extends CommonController<ReservationParams, ReservationEntity, ReservationDto> {

  @Autowired
  private final ReservationService service;

  public ReservationController(ReservationService service) {
    this.service = service;
  }

  @Override
  public CommonService<ReservationParams, ReservationEntity, ReservationDto> getService() {
    return service;
  }

  @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<ReservationDto>> getUserCars(Map<String, Object> model, @RequestBody ReservationParams params) {
    List<ReservationDto> list = this.filter(model, params);
    return new ResponseEntity<List<ReservationDto>>(list, HttpStatus.OK);
  }

}
