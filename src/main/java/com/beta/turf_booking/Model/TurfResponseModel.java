package com.beta.turf_booking.Model;

import com.beta.turf_booking.Domain.Slot;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TurfResponseModel {
    private static final long serialVersionUID = 1L;

    private long id;
    private String name;
    private String type;
    private String phone;
    private String city;
    private String area;

    private List<SlotResponseModel> slots;

}
