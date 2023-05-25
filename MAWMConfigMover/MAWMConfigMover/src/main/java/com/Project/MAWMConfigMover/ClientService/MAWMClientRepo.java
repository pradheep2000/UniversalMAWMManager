package com.Project.MAWMConfigMover.ClientService;

import com.Project.MAWMConfigMover.Clients.MAWMClients;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MAWMClientRepo extends JpaRepository<MAWMClients, Long> {
}
