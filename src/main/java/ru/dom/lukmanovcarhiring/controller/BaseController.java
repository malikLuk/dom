package ru.dom.lukmanovcarhiring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import ru.dom.lukmanovcarhiring.service.BaseService;

@RestController
public class BaseController {

    @Autowired
    private BaseService service;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @RequestMapping(value = "/hire", method = RequestMethod.POST)
    public ModelAndView hire() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("hire");
        service.getAllCars();
        return modelAndView;
    }

}
