package com.library.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler" , "bookings"})
public class Rider extends BaseModel {

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String phoneNumber;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @OneToOne
    private Booking activeBooking;

    @DecimalMin(value="0.01",message="Rating must be greater than or equal to 0.00")
    @DecimalMax(value="5.00", message="Rating must be less than or equal to 5")
    private Double averageRating;

    @OneToOne
    private ExactLocation lastKnownLocation;

    @OneToOne
    private ExactLocation homeLocation; //Improvisation: List of home locations we can save.

    //property name in 'many' class(booking) should be same as here mentioned in mappedBy
    @OneToMany(mappedBy = "rider") //mapping instruction : to mention this 1:N to be mapped to rider field in Booking.
    private List<Booking> bookings = new ArrayList<>();
}