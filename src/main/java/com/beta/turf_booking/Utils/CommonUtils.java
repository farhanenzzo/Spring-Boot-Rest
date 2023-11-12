package com.beta.turf_booking.Utils;

import com.beta.turf_booking.Domain.Slot;
import com.beta.turf_booking.Model.SlotResponseModel;

import java.util.List;
import java.util.stream.Collectors;

public class CommonUtils {

    public static List<SlotResponseModel> mapToSlotResponseModels(List<Slot> slots) {
        return slots.stream()
                .map(Slot::mapToSlotResponseModel)
                .collect(Collectors.toList());
    }
}
