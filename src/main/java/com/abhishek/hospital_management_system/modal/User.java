package com.abhishek.hospital_management_system.modal;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.List;

@Data
public class User {
    @MongoId
    private String _id;
    private String name;
    private String email;
    private String password;
    private String dob;
    private int age;
    private int contacts;
    private Appointment appointmentsMade;
    private boolean isDisabled;
    private List<String> report;

}
