package com.beta.turf_booking.Controller;

import com.beta.turf_booking.Domain.Slot;
import com.beta.turf_booking.Model.SlotRequestModel;
import com.beta.turf_booking.Model.SlotResponseModel;
import com.beta.turf_booking.Service.SlotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.beta.turf_booking.Utils.CommonUtils.mapToSlotResponseModels;

@RestController
@RequestMapping("/slot")
public class SlotController {

    @Autowired
    private SlotService slotService;

    @GetMapping
    public List<SlotResponseModel> showSlot() {

        return mapToSlotResponseModels(slotService.getAllSlot());
    }

    @PostMapping
    public String createSlot(@RequestBody SlotRequestModel slotRequestModel) {
        Slot slot = slotService.createNewSlot(slotRequestModel);
        return "New Slot has been added !";
    }

    @GetMapping("/{id}")
    public SlotResponseModel findSlot(@PathVariable Long id) {
        Slot slot = slotService.findSlotById(id);

        return slot.mapToSlotResponseModel();
    }

    @DeleteMapping()
    public String deleteSlot(@RequestBody Slot slot) {
        boolean deleted = slotService.deleteSlotById(slot.getId());

        if (deleted) {
            return "Slot has been deleted";
        } else {
            return "Slot not available";
        }
    }

    @PutMapping()
    public String updateSlot(@RequestBody Slot updateSlot) {
        boolean updated = slotService.updateSlotById(updateSlot.getId(), updateSlot);

        if (updated) {
            return "Slot has been updated";
        } else {
            return "Slot not available";
        }
    }
}
