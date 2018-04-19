package ru.dom.lukmanovcarhiring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import ru.dom.lukmanovcarhiring.common.dao.CommonParams;
import ru.dom.lukmanovcarhiring.dto.CarsDto;
import ru.dom.lukmanovcarhiring.service.BaseService;

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

    @RequestMapping(value = "/hire", method = RequestMethod.POST)
    public ModelAndView hire(P params) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("hire");
        List<CarsDto> cars = service.getAllCars(params);
        modelAndView.addObject("cars", cars);
        return modelAndView;
    }

}
