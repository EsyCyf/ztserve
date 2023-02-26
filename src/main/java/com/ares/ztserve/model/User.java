package com.ares.ztserve.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ESy
 * @date 2023/2/26 026 22:14
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String account;
    private String password;
    private String role;

}
