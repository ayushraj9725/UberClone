package com.example.reviewService.Adapters;

import com.example.reviewService.DTOs.PassengerReviewDto;
import com.example.reviewService.Models.Booking;
import com.example.reviewService.Models.PassengerReview;
import com.example.reviewService.Models.Review;
import com.example.reviewService.Repositories.BookingRepository;
import com.example.reviewService.Repositories.PassengerReviewRepository;
import org.antlr.v4.runtime.misc.LogManager;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class PassengerReviewAdapterImp implements PassengerReviewAdapter{

    private final BookingRepository bookingRepository ;

    public PassengerReviewAdapterImp(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;

    }

    @Override
    public PassengerReview ConvertDTOPRtoB(PassengerReviewDto passengerReviewDto) throws IllegalArgumentException {

        Optional<Booking> bookingOpt = bookingRepository.findById(passengerReviewDto.getBookingId());
        if (bookingOpt.isEmpty())
        {
            throw new IllegalArgumentException("Invalid booking ID: " + passengerReviewDto.getBookingId());
        }

        Booking booking = bookingOpt.get();

        PassengerReview pr = new PassengerReview();

        pr.setPassengerRating(passengerReviewDto.getPassengerRating());
        pr.setPassengerComment(passengerReviewDto.getPassengerComment());
        pr.setRating((double) passengerReviewDto.getPassengerRating()); // from superclass
        pr.setComment(passengerReviewDto.getPassengerComment()); // from superclass
        pr.setBooking(booking);  // MUST NOT be null


        return pr;


       /* try {
            Optional<Booking> booking = this.bookingRepository.findById(passengerReviewDto.getBookingId());

            if (booking.isEmpty()) {
                return null;
            }

            return PassengerReview.builder()
                    .passengerRating(Double.valueOf(passengerReviewDto.getPassengerRating()))
                    .passengerComment(passengerReviewDto.getPassengerComment())
                    .booking(booking.get())
                    .comment(passengerReviewDto.getPassengerComment()) // from base class
                    .rating(Double.valueOf(passengerReviewDto.getPassengerRating())) // from base class
                    .build();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        */
    }


}
