package com.library.models;

import jakarta.persistence.*;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name="bookingReview")
@Inheritance(strategy = InheritanceType.JOINED)
public class Review extends BaseModel{

    @Column(nullable = false)
    private String content;

    @Column
    private Double rating;

    @OneToOne(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private Booking booking; // we have defined a 1:1 relationship between booking and review

    @Override
    public String toString() {
        return "Review{" +
                "content='" + content + '\'' +
                ", rating=" + rating +
                ", booking=" + booking +
                '}';
    }
}

/*
* Booking can exist without a review. But Review should not exist without Booking.
* So removed Review in Booking. Add Booking in Review table.
* */