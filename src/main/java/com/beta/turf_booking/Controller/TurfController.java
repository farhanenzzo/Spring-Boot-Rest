package com.beta.turf_booking.Controller;

import com.beta.turf_booking.Domain.Turf;
import com.beta.turf_booking.Model.TurfResponseModel;
import com.beta.turf_booking.Service.TurfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/turf")
public class TurfController {

    @Autowired
    private TurfService turfService;

    @GetMapping
    public List<TurfResponseModel> showTurf() {
        return turfService.showAllTurf()
                .stream()
                .map(Turf::mapToTurfResponseModel)
                .collect(Collectors.toList());
    }

    @PostMapping
    public String createTurf(@RequestBody Turf turf) {
        turfService.createNewTurf(turf);
        return "New turf has been added !";
    }

    @GetMapping("/{id}")
    public TurfResponseModel findTurf(@PathVariable Long id) {
        Turf turf = turfService.findTurfById(id);
        return turf.mapToTurfResponseModel();
    }

    @DeleteMapping()
    public String deleteTurf(@RequestBody Turf turf) {
        boolean deleted = turfService.deleteTurfById(turf.getId());

        if (deleted) {
            return "Turf has been deleted";
        } else {
            return "Turf not available";
        }
    }

    @PutMapping()
    public String updateTurf(@RequestBody Turf updateTurf) {
        boolean updated = turfService.updateTurfById(updateTurf.getId(), updateTurf);

        if (updated) {
            return "Turf has been updated";
        } else {
            return "Turf not available";
        }
    }
}
