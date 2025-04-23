package com.example.reviewService.Models;

import jakarta.persistence.*;
import jdk.jfr.Name;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;

@Entity  // this annotation helps us to use to do logical task in module using this we are creating a real entity review table in our database
 // @Name("Booking_review")  // this will not use to named table
@Table(name = "Booking_review")

public class Review {

    @Id // this annotation makes the id property to a primary key of table
    @GeneratedValue(strategy = GenerationType.IDENTITY)         // identity means auto_increment
    long id ;

    @Column(nullable = false)  // this is ensured that the comment not be null
    String comment ;

    Double rating ;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP) // this annotation tells to spring , what type of format of this attribute to be stored into the table i.e. Date / Time / Timestamp
    @CreatedDate  // this annotation tells that spring handle only for the object creation time and date
    Date createdAt ;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate // this annotation tells that spring handle only for the object update last time and date
    Date updatedAt ;



}
