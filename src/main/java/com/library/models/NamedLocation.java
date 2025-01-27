package com.library.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.*;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NamedLocation extends BaseModel {

    @OneToOne
    private ExactLocation exactLocation;

    private String name;

    private String zipCode;

    private String city; //ideally we should have different city model also. for now, simplified

    private String country;

    private String state;
}
