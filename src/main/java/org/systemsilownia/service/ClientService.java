package org.systemsilownia.service;

import org.systemsilownia.repository.ClientRepository;
import org.systemsilownia.repository.entity.Client;

public class ClientService {
    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }
    public boolean save(Client client) {return clientRepository.save(client);}

    public Client findByEmail(String email) {return clientRepository.findByEmail(email);}

    public boolean login(String fromEmail, String fromPassword) {
        Client logClient = clientRepository.findByEmail(fromEmail);
        return (logClient != null && logClient.getPassword().equals(fromPassword));
    }

    public boolean register(Client client){
        return clientRepository.save(client);
    }

}
