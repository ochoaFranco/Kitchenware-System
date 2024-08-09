package com.kitchenware.api.service;

import com.kitchenware.api.entity.Client;
import com.kitchenware.api.repository.IClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService implements IClientService {
    @Autowired
    IClientRepository clientRepo;

    // Create a client.
    @Override
    public void saveClient(Client client) {
        clientRepo.save(client);
    }

    // Get all clients.
    @Override
    public List<Client> getClients() {
        return clientRepo.findAll();
    }

    // Get one client.
    @Override
    public Optional<Client> getClientById(Long id) {
        return clientRepo.findById(id);
    }

    // Edit a product.
    @Override
    public void editClient(Long id, Client client) {
        Optional<Client> optionalClient = this.getClientById(id);
        Client c = optionalClient.get();
        // Setting attributes.
        if (client.getName() != null)
            c.setName(client.getName());
        if (client.getLastname() != null)
            c.setLastname(client.getLastname());
        if (client.getIdentification() != null)
            c.setIdentification(client.getIdentification());

        this.saveClient(c);
    }

    // Delete a client.
    @Override
    public void deleteClient(Long id) {
        clientRepo.deleteById(id);
    }
}
