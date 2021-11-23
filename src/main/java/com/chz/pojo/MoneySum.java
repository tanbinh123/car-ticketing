package com.chz.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author snicker
 * @date 2021/11/23 16:58
 * @Describe
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MoneySum {
    private String carNum;
    private double money;
}
