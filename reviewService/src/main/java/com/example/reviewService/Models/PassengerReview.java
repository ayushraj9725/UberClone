package com.example.reviewService.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@PrimaryKeyJoinColumn(name = "passenger_review_id")
public class PassengerReview extends Review{

    @Column(nullable = false)
    private String passengerComment;

    @Column(nullable = false)
    private float passengerRating;

}
