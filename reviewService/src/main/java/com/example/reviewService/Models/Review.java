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

@Entity  // this annotation helps us to use to do logical task in module using this we are creating a real entity review table in our database
 // @Name("Booking_review")  // this will not use to named table
@Table(name = "Booking_review")  // using this we can define custom name of table using java in my db

public class Review extends BaseModel{

    @Column(nullable = false)  // this is ensured that the comment not be null
    private String comment ;

    private Double rating ;


}
