package com.abhishek.hospital_management_system.modal;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.time.LocalDateTime;
import java.util.Date;

@Data
public class Report {
    @MongoId
    private String _id;
    private String type;
    private String img;
    private String desc;
    private String title;
    private Date date;
}
