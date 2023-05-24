package com.Project.MAWMConfigMover.ClientServiceImpl;

import com.Project.MAWMConfigMover.ClientService.ClientRepository;
import com.Project.MAWMConfigMover.Clients.Clients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl {

    @Autowired
    private ClientRepository clientRepository;

    public List<Clients> findAll() {
        return clientRepository.findAll();
    }
}
