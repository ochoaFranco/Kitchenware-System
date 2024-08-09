package com.kitchenware.api.service;
import com.kitchenware.api.entity.Client;
import java.util.List;
import java.util.Optional;

public interface IClientService {
    // Create method.
    void saveClient(Client client);

    // get all clients.
    List<Client> getClients();

    // get one client.
    Optional<Client> getClientById(Long id);

    // update a whole client.
    void editClient(Long id, Client client);

    // delete one client by id.
    void deleteClient(Long id);
}
