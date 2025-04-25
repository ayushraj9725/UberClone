package com.example.reviewService.Models;

import jakarta.persistence.*;
import jdk.jfr.Name;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@Getter    // this annotation internally create the getter and setter both for those property of review class using lombok
@Setter
@Builder   // this annotation helps us to use builder pattern in our project , lombok aspect this and give features to us
@NoArgsConstructor    // in aspect of using builder annotation we have to use this annotation both about constructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Entity  // this annotation helps us to use to do logical task in module using this we are creating a real entity review table in our database
 // @Name("Booking_review")  // this will not use to named table
@Table(name = "Booking_review")  // using this we can define custom name of table using java in my db

public class Review {

    @Id // this annotation makes the id property to a primary key of table
    @GeneratedValue(strategy = GenerationType.IDENTITY)         // identity means auto_increment
    private long id ;

    @Column(nullable = false)  // this is ensured that the comment not be null
    private String comment ;

    private Double rating ;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP) // this annotation tells to spring , what type of format of this attribute to be stored into the table i.e. Date / Time / Timestamp
    @CreatedDate  // this annotation tells that spring handle only for the object creation time and date
    private Date createdAt ;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate // this annotation tells that spring handle only for the object update last time and date
    private Date updatedAt ;



}
