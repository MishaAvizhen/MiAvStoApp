package com.netcracker.miavstoapp.controller;

import com.netcracker.miavstoapp.dto.RepairRequestDto;
import com.netcracker.miavstoapp.dto.UserRegistrationDto;
import com.netcracker.miavstoapp.entity.RepairRequest;
import com.netcracker.miavstoapp.entity.User;
import com.netcracker.miavstoapp.service.RepairRequestService;
import com.netcracker.miavstoapp.service.SecurityService;
import com.netcracker.miavstoapp.service.UserService;
import com.netcracker.miavstoapp.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller

public class RepairRequestController {
    @Autowired
    private UserService userService;
    @Autowired
    private RepairRequestService repairRequestService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;

    @RequestMapping(value = "/createRepairRequest", method = RequestMethod.GET)
    public String createRepairRequest(Model model) {
        model.addAttribute("repairRequestForm", new RepairRequestDto());

        return "createRepairRequest";
    }

    @RequestMapping(value = "/createRepairRequest", method = RequestMethod.POST)
    public String registration(@ModelAttribute("repairRequestForm") RepairRequestDto repairRequestDto, BindingResult bindingResult,
                               Authentication authentication, Model model) {
        if (bindingResult.hasErrors()) {
            return "createRepairRequest";
        }
        repairRequestService.createRepairRequest(repairRequestDto, authentication.getName());
        model.addAttribute("message", "Repair request  was added");


        return "redirect:/welcome";

    }
}
