package org.systemsilownia.service;

import org.systemsilownia.repository.ClientLoginMenuRepository;
import org.systemsilownia.repository.entity.Client;

public class ClientService {
    private final ClientLoginMenuRepository clientRepository;

    public ClientService(ClientLoginMenuRepository clientRepository) {
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
