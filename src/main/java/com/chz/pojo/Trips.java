package com.chz.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author snicker
 * @date 2021/11/12 10:28
 * @Describe
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Trips {
    private int id;
    private String orginLocation;
    private String destinationLocation;
    @DateTimeFormat(pattern="hh:mm:ss")
    private String startTime;
    @DateTimeFormat(pattern="hh:mm:ss")
    private String reachTime;
    private String spanDays;
    private String carNum;
    private Double ticketPrice;
    private int ticketNum;
}
