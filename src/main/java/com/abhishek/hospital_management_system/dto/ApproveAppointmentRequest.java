package com.abhishek.hospital_management_system.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApproveAppointmentRequest {
    private String date;
    private String token;
    private String doctime;
    private ObjectId assignedDoc;
}
