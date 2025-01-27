package com.library.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Color extends BaseModel{

    @Column(unique = true, nullable = false)
    private String colorName;
}


/*
we may think we can do this using Enum. But what if we want to add one more new color,
then the whole project to be re-deployed. So DB update better to do.
 */

