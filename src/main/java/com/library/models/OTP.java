package com.library.models;

import jakarta.persistence.Entity;
import lombok.*;

import java.util.Random;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OTP extends  BaseModel{

    private String code;

    private String sentToNumber;

    public static OTP createOTP(String phoneNumber){
        Random random=new Random();
        Integer otp=random.nextInt(9000)+1000;  //(0....8999)+1000===> (1000...9999) comes
        return OTP.builder()
                .sentToNumber(phoneNumber)
                .code(otp.toString())
                .build();
    }
}

//Ideally we should generate OTP randomly. we shall see that later.
//If OTP is 4 digit : 1000<=x<=9999