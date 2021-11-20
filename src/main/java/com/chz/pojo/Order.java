package com.chz.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author snicker
 * @date 2021/11/12 16:35
 * @Describe
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private int id;
    private int carInfoId;
    private int personId;
    private int changeTimes;
    //1是预定未付款， 2是已经支付， 3是已退票
    private int status;
    private String stautsMsg;
}
