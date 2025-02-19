package com.abhishek.hospital_management_system.modal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vacancy {
    private boolean status;
    private int amount;
    private String position;
    private String desc;
}
