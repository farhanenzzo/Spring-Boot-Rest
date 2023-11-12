package com.beta.turf_booking.Repository;

import com.beta.turf_booking.Domain.Slot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SlotRepo extends JpaRepository<Slot, Long> {
}
