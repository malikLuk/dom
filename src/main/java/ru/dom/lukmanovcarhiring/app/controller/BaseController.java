package ru.dom.lukmanovcarhiring.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import ru.dom.lukmanovcarhiring.common.dao.CommonParams;
import ru.dom.lukmanovcarhiring.app.dto.CarDto;
import ru.dom.lukmanovcarhiring.app.service.BaseService;

import java.util.List;

@RestController
public class BaseController<P extends CommonParams> {

    @Autowired
    private BaseService service;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @RequestMapping(value = "/hire"/*, method = RequestMethod.GET*/)
    public ModelAndView hire(P params) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("hire");
        List<CarDto> carList = service.getAllCars(params);
        modelAndView.addObject("carList", carList);
        return modelAndView;
    }

}
