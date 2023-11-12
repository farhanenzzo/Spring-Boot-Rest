package com.beta.turf_booking.Repository;

import com.beta.turf_booking.Domain.Turf;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TurfRepo  extends JpaRepository<Turf, Long> {

}
