package com.abhishek.hospital_management_system.modal;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Hospital {
    @MongoId
    private String _id;
    @NotBlank(message = "Name can't be blank")
    private String name;
    private String address;
    private String contact1;
    private String contact2;
    private String email;
    private String password;
    private List<HospitalService> services;
    private List<HospitalImage> hospitalImages;
    private String hospitalProfilePics;
    private String hospitalDescription;
    @DBRef
    @JsonManagedReference
    private List<Doctor> doctors;
    private List<EmergencyContact> emergencyContacts;
    private int ambulance;
    private BedCapacity beds;
    private BedType bedType;
    private List<Vacancy> vacancy;
    @DBRef
    @JsonManagedReference
    private List<Appointment> appointments;
    @DBRef
    private List<Review> reviews;
    @DBRef
    private List<User> patient;
    private List<Event> events;
}
