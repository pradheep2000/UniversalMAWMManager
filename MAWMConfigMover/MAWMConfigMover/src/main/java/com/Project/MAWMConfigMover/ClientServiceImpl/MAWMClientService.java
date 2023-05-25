package com.Project.MAWMConfigMover.ClientServiceImpl;

import com.Project.MAWMConfigMover.ClientService.MAWMClientRepo;
import com.Project.MAWMConfigMover.Clients.MAWMClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MAWMClientService {

    @Autowired
    private MAWMClientRepo mawmClientRepo;
    public List<MAWMClients> getAllSites() {
        List<MAWMClients> clients = new ArrayList<>();
        mawmClientRepo.findAll().forEach(clients::add);
        return clients;
    }
    public List<MAWMClients> findAll() {
        return mawmClientRepo.findAll();
    }
}
