package com.abhishek.hospital_management_system.repository;

import com.abhishek.hospital_management_system.modal.Medicine;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MedicalRepository extends MongoRepository<Medicine, ObjectId> {
}
