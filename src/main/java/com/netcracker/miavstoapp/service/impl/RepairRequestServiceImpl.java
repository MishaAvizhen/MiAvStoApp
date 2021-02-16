package com.netcracker.miavstoapp.service.impl;


import com.netcracker.miavstoapp.constants.RepairRequestConstants;
import com.netcracker.miavstoapp.dao.RepairRequestDao;
import com.netcracker.miavstoapp.dao.UserDao;
import com.netcracker.miavstoapp.dto.RepairRequestDto;
import com.netcracker.miavstoapp.entity.RepairRequest;
import com.netcracker.miavstoapp.entity.User;
import com.netcracker.miavstoapp.service.RepairRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RepairRequestServiceImpl implements RepairRequestService {
    @Autowired
    private RepairRequestDao repairRequestDao;
    @Autowired
    private UserDao userDao;

    @Transactional
    @Override
    public RepairRequest createRepairRequest(RepairRequestDto repairRequestDto, String username) {
        RepairRequest repairRequest = new RepairRequest();
        repairRequest.setDateOfRequest(repairRequestDto.getDateOfRequest());
        repairRequest.setCarRemark(repairRequestDto.getCarRemark());
        repairRequest.setRepairRequestDescription(repairRequestDto.getRepairRequestDescription());
        repairRequest.setStatus(RepairRequestConstants.STATUS_IN_PROGRESS);
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String user = ((UserDetails) principal).getUsername();
        User byUsername = userDao.findByUsername(user);
        repairRequest.setUser(byUsername);


        return repairRequestDao.save(repairRequest);
    }
}
