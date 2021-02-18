package com.netcracker.miavstoapp.controller;

import com.netcracker.miavstoapp.dto.RepairRecordDto;
import com.netcracker.miavstoapp.dto.RepairRequestDto;
import com.netcracker.miavstoapp.entity.User;
import com.netcracker.miavstoapp.service.RepairRecordService;
import com.netcracker.miavstoapp.service.RepairRequestService;
import com.netcracker.miavstoapp.service.SecurityService;
import com.netcracker.miavstoapp.service.UserService;
import com.netcracker.miavstoapp.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RepairRecordController {
    @Autowired
    private UserService userService;
    @Autowired
    private RepairRequestService repairRequestService;
    @Autowired
    private RepairRecordService repairRecordService;
    @Autowired
    private SecurityService securityService;
    @Autowired
    private UserValidator userValidator;


    @RequestMapping(value = "/addRepairRecord/{repairRequestId}", method = RequestMethod.GET)
    public String createRepairRecord(Model model,  @PathVariable Long  repairRequestId) {
        RepairRecordDto repairRecordDto = new RepairRecordDto();
        repairRecordDto.setRepairRequestId(repairRequestId);
        model.addAttribute("repairRecordForm", repairRecordDto);
        return "addRepairRecord";
    }

    @RequestMapping(value = "/addRepairRecord/{repairRequestId}", method = RequestMethod.POST)
    public String addRepairRecord(@ModelAttribute("repairRecordForm") RepairRecordDto repairRecordDto,
                                  @PathVariable Long  repairRequestId, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("message", "Repair request  wasn't added");
        }
        repairRecordDto.setRepairRequestId(repairRequestId);
        repairRecordService.addRepairRecord(repairRecordDto);
        model.addAttribute("message", "Repair record  was added");
        return "redirect:/allUserRepairRequests";
    }


}
