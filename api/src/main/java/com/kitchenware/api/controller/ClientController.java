package com.kitchenware.api.controller;

import com.kitchenware.api.entity.Client;
import com.kitchenware.api.service.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clients")
public class ClientController {
    @Autowired
    private IClientService clientServ;

    // Create a client.
    @PostMapping("/create")
    public ResponseEntity<Client> saveClient(@RequestBody Client client) {
        clientServ.saveClient(client);
        return new ResponseEntity<>(client, HttpStatus.CREATED);
    }

    // Read all clients.
    @GetMapping()
    public ResponseEntity<List<Client>> getClients() {
        List<Client> clientList = clientServ.getClients();
        return new ResponseEntity<>(clientList, HttpStatus.OK);
    }

    // Read one client.
    @GetMapping("/{id}")
    public ResponseEntity<Client> getProducById(@PathVariable Long id) {
        Optional<Client> optionalClient = clientServ.getClientById(id);
        if (optionalClient.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        Client client = optionalClient.get();

        return new ResponseEntity<>(client, HttpStatus.OK);
    }

    // Update a whole client.
    @PutMapping("/edit")
    public ResponseEntity<Client> editClient(@RequestBody Client client) {
        clientServ.saveClient(client);
        return new ResponseEntity<>(client, HttpStatus.OK);
    }

    // Update client by its ID.
    @PutMapping("/edit/{id}")
    public ResponseEntity<Client> editClient(
            @PathVariable Long id,
            @RequestBody Client client) {

        Optional<Client> optionalClient = clientServ.getClientById(id);
        if (optionalClient.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        clientServ.editClient(id, client);
        return new ResponseEntity<>(client, HttpStatus.OK);
    }


    // Delete a client by its ID.
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteClient(@PathVariable Long id) {
        try {
            clientServ.deleteClient(id);
            return new ResponseEntity<>("The client was deleted", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("The was an error", HttpStatus.BAD_REQUEST);
        }
    }
}
