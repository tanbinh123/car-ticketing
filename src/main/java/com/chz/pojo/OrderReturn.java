package com.chz.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author snicker
 * @date 2021/11/13 17:39
 * @Describe
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderReturn {
    private Integer id;
    private String orginLocation;
    private String destinationLocation;
    //    @DateTimeFormat(pattern="yyyy-MM-dd hh:mm:ss")
    private String startTime;
    //    @DateTimeFormat(pattern="yyyy-MM-dd hh:mm:ss")
    private String reachTime;
    private String carNum;
    private Double ticketPrice;
    private int ticketNum;
    private String trueName;
    private String idCardNum;
    private String phoneNum;
    private String status;
}
