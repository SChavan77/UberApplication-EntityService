package com.library.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler" , "bookings"})
public class Driver extends BaseModel{

    private String name;
    private String address;
    private String phoneNumber;

    @Column(nullable = true, unique = true)
    private String licenseNumber;

    @Column
    private String idCard;

    @OneToOne(mappedBy = "driver", cascade=CascadeType.ALL)
    private Car car;

    @Enumerated(value=EnumType.STRING)
    private DriverApprovalStatus driverApprovalStatus;

    @OneToOne
    private ExactLocation lastKnownLocation; //this keeps on updating the live location

    @OneToOne
    private ExactLocation homeLocation; //at the EOD, sometime, they get thier rides nearby to their home.

    private String activeCity;

    @DecimalMin(value="0.01",message="Rating must be greater than or equal to 0.00")
    @DecimalMax(value="5.00", message="Rating must be less than or equal to 5")
    private Double averageRating;

    private Boolean isAvailable;

    //1: N : driver has many bookings/reviews
    @OneToMany(mappedBy = "driver",fetch= FetchType.LAZY)
    @Fetch(FetchMode.SUBSELECT) //means: fetch them in a batch
    private List<Booking> bookings=new ArrayList<>();
}