package com.abhishek.hospital_management_system.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddDoctorReview {
    private String comment;
    private String userId;
    private int ratings;
    private Date date;
    private String username;
    private String profilePic;
}
