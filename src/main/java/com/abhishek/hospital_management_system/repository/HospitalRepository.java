package com.abhishek.hospital_management_system.repository;

import com.abhishek.hospital_management_system.modal.Hospital;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HospitalRepository extends MongoRepository<Hospital, ObjectId> {
    Optional<Hospital> findByEmail(String email);
}
