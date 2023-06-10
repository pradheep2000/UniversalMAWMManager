package com.Project.MAWMConfigMover.ClientServiceImpl;

import com.Project.MAWMConfigMover.ClientService.MAWMClientRepo;
import com.Project.MAWMConfigMover.Clients.MAWMClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MAWMClientService {

    List<MAWMClients> listClients = new ArrayList<>();
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

    public MAWMClients saveSite(MAWMClients client) {
        return mawmClientRepo.save(client);
    }

    public List<MAWMClients> fetchDataByClientcode(String clientcode) {
        return mawmClientRepo.findAllByclientcode(clientcode);
    }
}
