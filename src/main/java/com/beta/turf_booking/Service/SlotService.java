package com.beta.turf_booking.Service;

import com.beta.turf_booking.Domain.Slot;
import com.beta.turf_booking.Domain.Turf;
import com.beta.turf_booking.Model.SlotRequestModel;
import com.beta.turf_booking.Repository.SlotRepo;
import com.beta.turf_booking.Repository.TurfRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class SlotService {

    @Autowired
    private SlotRepo slotRepo;

    @Autowired
    private TurfRepo turfRepo;

    public List<Slot> getAllSlot() {
        return slotRepo.findAll();
    }

    public Slot createNewSlot(SlotRequestModel slotRequestModel) {
        long turfId = slotRequestModel.getTurfId();
        Turf turf = turfRepo.findById(turfId).get();

        Slot slot = Slot.mapToSlot(slotRequestModel, turf);
        turf.addSlot(slot);

        return slotRepo.save(slot);
    }

    public Slot findSlotById(long id) {
        return slotRepo.findById(id).orElse(null);
    }

    public boolean updateSlotById(long id, Slot updateSlot) {
        Optional<Slot> slotOptional = slotRepo.findById(id);

        if(slotOptional.isPresent()) {
            Slot slot = slotOptional.get();

            slot.setName(updateSlot.getName());
            slot.setStartTime(updateSlot.getStartTime());
            slot.setEndTime(updateSlot.getEndTime());
            slot.setCost(updateSlot.getCost());
            slot.setStatus(updateSlot.getStatus());
            slotRepo.save(slot);

            return true;
        }
        return false;
    }

    public boolean deleteSlotById(long id) {
        try {
            slotRepo.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
