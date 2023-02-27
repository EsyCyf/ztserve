package com.ares.ztserve.service;

import com.ares.ztserve.model.Client;

/**
 * @author ESy
 * @date 2023/2/27 027 9:37
 */
public interface ClientService {
    Client findClientByName(String email);
}
