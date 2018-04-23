package ru.dom.lukmanovcarhiring.app.registr_auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.dom.lukmanovcarhiring.app.dto.UserDto;
import ru.dom.lukmanovcarhiring.app.registr_auth.dao.entity.UserEntity;
import ru.dom.lukmanovcarhiring.configuration.security.UserService;

import javax.validation.Valid;

@RestController
@RequestMapping("/registration")
public class RegistrationController {

    @Autowired
    private UserService userService;

    @ModelAttribute("userEntity")
    public UserDto getUserDto() {
        return new UserDto();
    }

    @GetMapping
    public ModelAndView registrationForm() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("registration");
        return modelAndView;
    }

    @PostMapping(/*value = "/register"*/)
    public ModelAndView registerAccount(@ModelAttribute("userEntity") @Valid UserDto userDto, BindingResult result) {
        ModelAndView modelAndView = new ModelAndView();
        if (result.hasErrors()){
            modelAndView.setViewName("registration");
            return modelAndView;
        }
        System.out.println(userDto);
        userService.saveUser(userDto);
        ModelAndView modelAndView1 = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;

    }

    /*@PostMapping(value = "/register")
    public void register() {
        System.out.println(0);
    }*/


}
