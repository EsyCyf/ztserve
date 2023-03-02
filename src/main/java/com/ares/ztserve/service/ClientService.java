package com.ares.ztserve.service;

import com.ares.ztserve.model.Client;

import java.util.List;

/**
 * @author ESy
 * @date 2023/2/27 027 9:37
 */
public interface ClientService {
    Client findActiveClientByName(String userName);
    List<Client> getClientInfo(Client client);
}
