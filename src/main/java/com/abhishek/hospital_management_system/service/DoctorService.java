package com.abhishek.hospital_management_system.service;

import com.abhishek.hospital_management_system.dto.AddDoctorReview;
import com.abhishek.hospital_management_system.dto.DoctorLoginRequest;
import com.abhishek.hospital_management_system.dto.DoctorLoginResponse;
import com.abhishek.hospital_management_system.dto.DoctorRegisterRequest;
import com.abhishek.hospital_management_system.modal.Doctor;
import com.abhishek.hospital_management_system.modal.Review;
import com.abhishek.hospital_management_system.repository.DoctorRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

@Service
public class DoctorService {
    @Autowired
    private DoctorRepository doctorRepository;

    public Optional<Doctor> addDoctorReview(AddDoctorReview addDoctorReview, ObjectId id) {
        Optional<Doctor> doctor=doctorRepository.findById(id);
        if(doctor.isPresent()){
            Doctor d=doctor.get();
            d.getReviews().add(new Review(new ObjectId().toHexString(), addDoctorReview.getComment(),
                    addDoctorReview.getUserId(), addDoctorReview.getUsername(),
                    addDoctorReview.getProfilePic(), addDoctorReview.getDate(), addDoctorReview.getRatings()));
            doctorRepository.save(d);
        }
        return doctor;
    }

    public DoctorLoginResponse doctorLogin(DoctorLoginRequest doctorLoginRequest) {
        Optional<Doctor> doctor=doctorRepository.findByEmail(doctorLoginRequest.getEmail());
        if(!doctor.isPresent()){
           return null;
        }
        Doctor d=doctor.get();
        return new DoctorLoginResponse(d.get_id(),d.getName(),d.getEmail(),d.getSpec(),d.getExp(),d.getContact(),d.getWorkingOn(),d.getGraduatedFrom());
    }

    public Doctor doctorRegister(DoctorRegisterRequest doctorRegisterRequest) {
        Optional<Doctor> doctor=doctorRepository.findByEmail(doctorRegisterRequest.getEmail());
        if (doctor.isPresent()){
            return null;
        }
        return doctorRepository.save(new Doctor(new ObjectId().toHexString(),doctorRegisterRequest.getName(),doctorRegisterRequest.getExp(),doctorRegisterRequest.getSpec(),doctorRegisterRequest.getContact(),doctorRegisterRequest.getEmail(), doctorRegisterRequest.getPassword(), "","" ,doctorRegisterRequest.getGraduatedFrom(),new Date(),new ArrayList<>(),doctorRegisterRequest.getWorkingOn()));

    }
}
