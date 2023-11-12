package com.beta.turf_booking.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TurfRequestModel {
    private static final long serialVersionUID = 1L;

    private long id;
    private String name;
    private String type;
    private String phone;
    private String city;
    private String area;
}
