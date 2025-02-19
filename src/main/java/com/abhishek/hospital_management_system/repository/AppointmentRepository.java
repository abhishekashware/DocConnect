package com.abhishek.hospital_management_system.repository;

import com.abhishek.hospital_management_system.modal.Appointment;
import com.abhishek.hospital_management_system.modal.AppointmentStatus;
import com.abhishek.hospital_management_system.modal.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AppointmentRepository extends MongoRepository<Appointment, ObjectId> {
    List<Appointment> findByStatus(AppointmentStatus appointmentStatus);

    List<Appointment> findByPatient(User user);
}
