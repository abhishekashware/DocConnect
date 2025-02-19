package com.abhishek.hospital_management_system.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SetAppointmentRequest {
    private int age;
    private int contact;
    private Date date;
    private String desc;
    private String location;
    private String name;
    private ObjectId patient;
    private String services;
    private String time;
}
