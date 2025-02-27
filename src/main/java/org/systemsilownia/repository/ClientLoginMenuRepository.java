package org.systemsilownia.repository;

import org.systemsilownia.repository.entity.Client;

public interface ClientLoginMenuRepository {
    Client save(Client client);
    Client findByEmail(String email);
    boolean checkMembershipExistsById(Long id);
}
