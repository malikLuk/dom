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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/car_hiring")
public class ReservationController extends CommonController<ReservationParams, ReservationEntity, ReservationDto> {

  @Autowired
  private final ReservationService reservationService;

  public ReservationController(ReservationService reservationService) {
    this.reservationService = reservationService;
  }

  @Override
  public CommonService<ReservationParams, ReservationEntity, ReservationDto> getService() {
    return reservationService;
  }

  @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<ReservationDto>> getUserCars(Map<String, Object> model, @RequestBody ReservationParams params) {
    List<ReservationDto> list = this.filter(model, params);
    return new ResponseEntity<List<ReservationDto>>(list, HttpStatus.OK);
  }

  @RequestMapping(value = "/reserve", method = RequestMethod.POST,
      produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Map<String, Long>> reserve(Map<String, Object> model, @RequestBody ReservationParams params) {
    reservationService.reserve(params);
    HashMap<String, Long> map = new HashMap<>();
    map.put("carId", params.getCarId());
    return new ResponseEntity<Map<String, Long>>(map, HttpStatus.OK);
  }

}
