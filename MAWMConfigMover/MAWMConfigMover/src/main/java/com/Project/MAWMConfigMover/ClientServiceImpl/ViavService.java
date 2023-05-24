package com.Project.MAWMConfigMover.ClientServiceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Project.MAWMConfigMover.Clients.Viav;
import com.Project.MAWMConfigMover.ClientService.ViavRepository;
@Service
public class ViavService {
    @Autowired
    public ViavRepository viavRepo;
    public List<Viav> getAllSites() {
        List<Viav> viav = new ArrayList<>();
        viavRepo.findAll().forEach(viav::add);
        return viav;
    }
    public void addSite(Viav subject) {
        viavRepo.save(subject);
    }
    public List<Viav> getSpSites(String clientCode) {
        List<Viav> viav = new ArrayList<>();
        viavRepo.findById(clientCode);
        return viav;
    }

}