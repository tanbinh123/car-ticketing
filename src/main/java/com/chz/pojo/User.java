package com.chz.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author snicker
 * @date 2021/11/10 16:28
 * @Describe
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private int id;
    private String username;
    private String password;
    private String trueName;
    private String idCardNum;
    private String phoneNum;
    private int age;
    private String sex;
}
