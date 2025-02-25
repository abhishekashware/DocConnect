package com.abhishek.hospital_management_system.modal;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.MongoId;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Appointment {
    @MongoId
    private String _id;
    private String name;
    private String services;
    private String location;
    private String desc;
    private int contact;
    private Date date;
    private String appointDate;
    private String docArrival;
    private String token;
    private int age;
    private AppointmentStatus status;
    private boolean inDoor;
    @DBRef
    private Doctor assignedDoctor;
    private Date followUp;
    @DBRef
    @JsonBackReference
    private Hospital withHospital;
    @DBRef
    private User patient;
    private boolean emergency;
    private boolean reqPickup;
    private boolean bill;
    @DBRef
    private List<Medicine> medicines;
}
