package com.beta.turf_booking.Service;

import com.beta.turf_booking.Domain.Turf;
import com.beta.turf_booking.Repository.TurfRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TurfService {

    @Autowired
    private TurfRepo turfRepo;

    public List<Turf> showAllTurf() {
        return turfRepo.findAll();
    }

    public void createNewTurf(Turf turf) {
        turfRepo.save(turf);
    }

    public Turf findTurfById(long id) {
        return turfRepo.findById(id).orElse(null);
    }

    public boolean updateTurfById(long id, Turf updateTurf) {
        Optional<Turf> turfOptional = turfRepo.findById(id);

        if(turfOptional.isPresent()) {
            Turf turf = turfOptional.get();

            turf.setName(updateTurf.getName());
            turf.setType(updateTurf.getType());
            turf.setPhone(updateTurf.getPhone());
            turf.setCity(updateTurf.getCity());
            turf.setArea(updateTurf.getArea());

            turfRepo.save(turf);

            return true;
        }
        return false;
    }

    public boolean deleteTurfById(long id) {
        try {
            turfRepo.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}


