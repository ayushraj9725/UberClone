package com.example.reviewService.Models;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity


@PrimaryKeyJoinColumn(name = "passenger_review_id")
public class PassengerReview extends Review {

    @Column(nullable = false)
    private String passengerComment;

    @Column(nullable = false)
    private Float passengerRating;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private Booking booking ;

}
