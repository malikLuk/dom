package ru.dom.lukmanovcarhiring.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.dom.lukmanovcarhiring.common.params.CommonParams;
import ru.dom.lukmanovcarhiring.app.dto.CarDto;
import ru.dom.lukmanovcarhiring.app.service.BaseService;

import java.util.List;

@Controller
public class BaseController<P extends CommonParams> {

    @Autowired
    private BaseService service;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String base() {
        return "redirect:/index";

    }

    /*@RequestMapping(value = "/hire")
    public ModelAndView hire(P params) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("hire");
        List<CarDto> carList = service.filter(params);
        modelAndView.addObject("carList", carList);
        return modelAndView;
    }*/

}
