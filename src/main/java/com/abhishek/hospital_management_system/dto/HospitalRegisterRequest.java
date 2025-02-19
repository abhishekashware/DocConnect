package com.abhishek.hospital_management_system.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HospitalRegisterRequest {

    private String name;
    private String email;
    private String password;
    private String contact1;
    private String contact2;

}
