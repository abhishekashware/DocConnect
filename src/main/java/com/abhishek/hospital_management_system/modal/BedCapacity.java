package com.abhishek.hospital_management_system.modal;

import lombok.Data;

@Data
public class BedCapacity {
    private int total;
    private int occupied;
    private int empty;

}
