package com.netcracker.miavstoapp.controller;

import com.netcracker.miavstoapp.dto.UserRegistrationDto;
import com.netcracker.miavstoapp.entity.User;
import com.netcracker.miavstoapp.service.SecurityService;
import com.netcracker.miavstoapp.service.UserService;
import com.netcracker.miavstoapp.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("userForm", new UserRegistrationDto());

        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") UserRegistrationDto userRegistrationDto, BindingResult bindingResult, Model model) {
//        userValidator.validate(userRegistrationDto, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        User registeredClient = userService.registerClient(userRegistrationDto);

        securityService.autoLogin(registeredClient.getUsername(), registeredClient.getPassword());
        model.addAttribute("message", "User" +registeredClient.getUsername()+ " was added");

        return "redirect:/welcome";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error != null) {
            model.addAttribute("error", "Username or password is incorrect.");
        }

        if (logout != null) {
            model.addAttribute("message", "Logged out successfully.");
        }

        return "login";
    }

    @RequestMapping(value = {"/", "/welcome"}, method = RequestMethod.GET)
    public String welcome(Model model) {
        return "welcome";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String admin(Model model) {
        return "admin";
    }
}