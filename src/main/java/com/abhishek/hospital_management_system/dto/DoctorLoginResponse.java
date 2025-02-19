package com.abhishek.hospital_management_system.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctorLoginResponse {
    private String _id;
    private String name;
    private String email;
    private String spec;
    private String exp;
    private int contact;
    private String workingOn;
    private String graduatedFrom;
}
