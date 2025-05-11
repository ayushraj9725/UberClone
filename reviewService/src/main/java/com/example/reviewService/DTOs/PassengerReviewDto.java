package com.example.reviewService.DTOs;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class PassengerReviewDto {

    private String passengerComment;

    private Float passengerRating;

    private Long bookingId ;


}
