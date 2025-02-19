package com.abhishek.hospital_management_system.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddMedicineRequest {

    private String desc;
    private String disease;
    private int timeInterval;
    private Date time;

}
