package ru.dom.lukmanovcarhiring.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import ru.dom.lukmanovcarhiring.app.dao.entity.CarEntity;
import ru.dom.lukmanovcarhiring.app.dto.CarDto;
import ru.dom.lukmanovcarhiring.app.params.CarParams;
import ru.dom.lukmanovcarhiring.app.service.CarService;
import ru.dom.lukmanovcarhiring.common.controller.CommonController;
import ru.dom.lukmanovcarhiring.common.service.CommonService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("car_hiring/car")
public class CarController extends CommonController<CarParams, CarEntity, CarDto> {

    @Autowired
    private CarService service;

    @Autowired
    public CarController(CarService service) {
        this.service = service;
    }

    @Override
    public CommonService<CarParams, CarEntity, CarDto> getService() {
        return service;
    }

    @RequestMapping
    public ModelAndView hire(Map<String, Object> model, CarParams params) {
        List<CarDto> list =  this.filter(model, params);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("car");
        modelAndView.addObject("carList", list);
        return modelAndView;
    }

    /*@Override
    public List<CarDto> filter(Map<String, Object> model, CarParams params) {
        List<CarDto> list =  super.filter(model, params);
    }*/


}
