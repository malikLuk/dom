package ru.dom.lukmanovcarhiring.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import ru.dom.lukmanovcarhiring.app.dao.entity.LocationEntity;
import ru.dom.lukmanovcarhiring.app.dto.LocationDto;
import ru.dom.lukmanovcarhiring.app.params.LocationParams;
import ru.dom.lukmanovcarhiring.app.service.LocationService;
import ru.dom.lukmanovcarhiring.common.controller.CommonController;
import ru.dom.lukmanovcarhiring.common.service.CommonService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("car_hiring/location")
public class LocationController extends CommonController<LocationParams, LocationEntity, LocationDto> {

    @Autowired
    private LocationService service;

    public LocationController(LocationService service) {
        this.service = service;
    }

    @Override
    public CommonService<LocationParams, LocationEntity, LocationDto> getService() {
        return service;
    }

    @RequestMapping
    public ModelAndView hire(Map<String, Object> model, LocationParams params) {
        List<LocationDto> list =  this.filter(model, params);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("location");
        modelAndView.addObject("locationList", list);
        return modelAndView;
    }

}
