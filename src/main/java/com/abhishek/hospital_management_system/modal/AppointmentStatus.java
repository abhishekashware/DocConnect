package com.abhishek.hospital_management_system.modal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentStatus {
    private boolean pending;
    private boolean done;
    private boolean rejected;
}
