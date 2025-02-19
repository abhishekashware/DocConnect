package com.abhishek.hospital_management_system.modal;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
public class Event {
    private String eventName;
    private Date date;
    private String desc;
    private String eventImg;
}
