package com.abhishek.hospital_management_system.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FollowUpRequest {
    private ObjectId doctorId;
    private Date followUp;
    private String token;
    private String doctime;
    private ObjectId assignedDoc;
}