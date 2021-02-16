package com.netcracker.miavstoapp.service;


import com.netcracker.miavstoapp.dto.RepairRequestDto;
import com.netcracker.miavstoapp.entity.RepairRequest;
import com.netcracker.miavstoapp.entity.User;

import java.util.List;

public interface RepairRequestService {
    RepairRequest createRepairRequest(RepairRequestDto repairRequestDto, String username);

    List<RepairRequest> getListAllRepairRequestOfUsers(String username);
}
