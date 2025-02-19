package com.abhishek.hospital_management_system.modal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Medicine {
    @MongoId
    private String _id;
    private String name;
    private String aka="";
    private String weight;
    private int cost;
    private String field;
    private String image;
    private String details;
    private String by;
}
