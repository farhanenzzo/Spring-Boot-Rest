package com.beta.turf_booking.Repository;

import com.beta.turf_booking.Domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {

}
