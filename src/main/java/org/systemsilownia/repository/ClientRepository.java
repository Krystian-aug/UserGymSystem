package org.systemsilownia.repository;

import org.systemsilownia.repository.entity.Client;

public interface ClientRepository {
    boolean save(Client client);
    Client findByEmail(String email);
}
