package com.abhishek.hospital_management_system.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaveMedicineRequest {
    private String name;
    private String weight;
    private int cost;
    private String field;
    private String aka;
    private String details;

}
