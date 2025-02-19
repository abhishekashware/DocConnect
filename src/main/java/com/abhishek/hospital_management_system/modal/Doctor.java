package com.abhishek.hospital_management_system.modal;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Doctor {
    @MongoId
    private String _id;
    private String name;
    private String exp;
    private String spec;
    private int contact;
    private String email;
    private String password;
    private String pic;
    private String doctorId;
    private String graduatedFrom;
    private Date newDate;
    private List<Review> reviews;
    private String workingOn;
}
