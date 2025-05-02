package com.example.reviewService.Models;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.security.PrivateKey;
import java.util.Date;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "booking")
public class Booking extends BaseModel{

    // doing some composition btw table because we want to define relation to interact as per need

    @OneToOne(cascade = CascadeType.ALL) // it helps to manage database when ever we perform delete operation , like we delete some independent table's data it will automatic delete dependent data
    private Review review; // here we have defined the 1:1 relationship between review and booking

    @Enumerated(value = EnumType.STRING) // it tells to db that our type is enum so mapping handle by JPA as string type data representation
    private BookingStatus bookingStatus ;

    @Temporal(value = TemporalType.TIMESTAMP)
    private Date startTime;

    @Temporal(value = TemporalType.TIMESTAMP)
    private Date endTime ;

    private long distance ;

    @ManyToOne(fetch = FetchType.LAZY)
    private Driver driver ;

    @ManyToOne(fetch = FetchType.LAZY)
    private Passenger passenger ;

}
