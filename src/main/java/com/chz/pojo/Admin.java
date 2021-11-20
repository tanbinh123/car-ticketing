package com.chz.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author snicker
 * @date 2021/11/10 17:17
 * @Describe
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Admin {
    private int id;
    private String username;
    private String password;
}
