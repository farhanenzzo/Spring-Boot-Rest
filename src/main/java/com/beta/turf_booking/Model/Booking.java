package com.beta.turf_booking.Model;

import com.beta.turf_booking.BookingStatus;
import com.beta.turf_booking.Domain.Slot;
import com.beta.turf_booking.Domain.User;

import javax.persistence.*;
import java.util.Date;

public class Booking {

    @Id
    long id;

    @ManyToOne()
    @JoinColumn()
    private Slot slot;

    @ManyToOne()
    private User user;

    private Date createdDate;

    @Enumerated(EnumType.STRING)
    private BookingStatus status;
}
