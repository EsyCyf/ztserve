package com.ares.ztserve.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ESy
 * @date 2023/2/23 023 16:23
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Client {
    private String customerNo;
    private String emailAddress;
    private String userRole;
}
