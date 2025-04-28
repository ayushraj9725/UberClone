package com.example.reviewService.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Rider extends BaseModel{

    private String name ;

    @OneToMany(mappedBy = "rider")
    private List<Booking> bookings = new ArrayList<>();

}
