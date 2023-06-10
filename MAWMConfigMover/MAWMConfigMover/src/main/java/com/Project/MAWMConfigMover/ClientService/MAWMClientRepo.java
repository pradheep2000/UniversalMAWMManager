package com.Project.MAWMConfigMover.ClientService;

import com.Project.MAWMConfigMover.Clients.MAWMClients;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MAWMClientRepo extends JpaRepository<MAWMClients, Long> {

    List<MAWMClients> findAllByclientcode(String clientcode);
}
