package com.beta.turf_booking.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SlotRequestModel {

    private static final long serialVersionUID = 1L;

    private long id;
    private String name;
    private String startTime;
    private String endTime;
    private String cost;
    private String status;
    private long turfId;

}



