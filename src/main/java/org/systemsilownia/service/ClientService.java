package org.systemsilownia.service;

import org.systemsilownia.repository.ClientLoginMenuRepository;
import org.systemsilownia.repository.entity.Client;
import org.systemsilownia.repository.entity.Membership;

public class ClientService {
    private final ClientLoginMenuRepository clientRepository;

    public ClientService(ClientLoginMenuRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client save(Client client) {return clientRepository.save(client);}
    public Client findByEmail(String email) {return clientRepository.findByEmail(email);}
    public boolean checkMembershipExistsById(Long id) {return clientRepository.checkMembershipExistsById(id);}

    public Client login(String fromEmail, String fromPassword) {
        Client client = clientRepository.findByEmail(fromEmail);
        if((client != null)&&(client.getPassword().equals(fromPassword))) {
            return client;
        }
        else{
            return null;
        }
    }

    public Client register(Client client){
        return clientRepository.save(client);
    }

    public boolean checkMembership(Client client) {
        Long fromID = client.getId();
        return checkMembershipExistsById(fromID);
    }

}
