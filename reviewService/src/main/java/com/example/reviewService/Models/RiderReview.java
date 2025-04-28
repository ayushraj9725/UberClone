package com.example.reviewService.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@PrimaryKeyJoinColumn(name = "rider_review_id")
public class RiderReview extends Review{

    @Column(nullable = false)
    private String rider_comment;

    @Column(nullable = false)
    private float rider_rating;

}
