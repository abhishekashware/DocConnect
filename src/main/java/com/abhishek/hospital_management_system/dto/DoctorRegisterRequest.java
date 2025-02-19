package com.abhishek.hospital_management_system.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DoctorRegisterRequest {

    private String email;
    private String password;
    private String name;
    private String spec;
    private String exp;
    private int contact;
    private String workingOn;
    private String graduatedFrom;
}
