package com.Project.MAWMConfigMover.ClientService;

import com.Project.MAWMConfigMover.Clients.Clients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Clients, Long> {
}
