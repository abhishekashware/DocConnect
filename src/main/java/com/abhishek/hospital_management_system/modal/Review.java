package com.abhishek.hospital_management_system.modal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Review {
        @MongoId
        private String _id;
        private String comment;
        private String userId;
        private String username;
        private String profilePic;
        private Date date;
        private int ratings;
}
