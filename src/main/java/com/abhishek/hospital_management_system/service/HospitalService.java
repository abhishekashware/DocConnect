package com.abhishek.hospital_management_system.service;

import com.abhishek.hospital_management_system.dto.HospitalRegisterRequest;
import com.abhishek.hospital_management_system.modal.Doctor;
import com.abhishek.hospital_management_system.modal.Hospital;
import com.abhishek.hospital_management_system.dto.HospitalLoginRequest;
import com.abhishek.hospital_management_system.repository.HospitalRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class HospitalService {
    @Autowired
    private HospitalRepository hospitalRepository;

    public Hospital registerHospital(HospitalRegisterRequest hospitalRegisterRequest) {
        Optional<Hospital> hospital=hospitalRepository.findByEmail(hospitalRegisterRequest.getEmail());
        if(hospital.isPresent()){
            return null;
        }
        Hospital newHospital=new Hospital(new ObjectId().toHexString(),hospitalRegisterRequest.getName(),"",hospitalRegisterRequest.getContact1(),
                hospitalRegisterRequest.getContact2(),hospitalRegisterRequest.getEmail(),hospitalRegisterRequest.getPassword(),
                new ArrayList<>(),new ArrayList<>(),"","",new ArrayList<>(),new ArrayList<>(),0,null,null,new ArrayList<>(),new ArrayList<>(),new ArrayList<>(),new ArrayList<>(),new ArrayList<>());

        hospitalRepository.save(newHospital);
        return newHospital;
    }

    public Optional<Hospital> loginHospital(HospitalLoginRequest hospitalLoginRequest) {
        Optional<Hospital> hospital=hospitalRepository.findByEmail(hospitalLoginRequest.getEmail());
        if(hospital.isPresent() && hospital.get().getPassword().equals(hospitalLoginRequest.getPassword())){
            return hospital;
        }
        return null;
    }

    public List<Hospital> getAllHospitals() {
        return hospitalRepository.findAll();
    }

    public Optional<Hospital> getHospitalById(ObjectId id) {
        return hospitalRepository.findById(id);
    }

    public Optional<Hospital> updateHospital(Hospital hospitalUpdateRequest,ObjectId id) {
        Optional<Hospital> hospital=hospitalRepository.findById(id);
        if(hospital.isPresent()){
            hospitalRepository.save(hospitalUpdateRequest);
        }
        return hospital;
    }

    public List<Doctor> getDoctorsByHospitalId(ObjectId id) {
        Optional<Hospital> hospital=hospitalRepository.findById(id);
        return hospital.map(Hospital::getDoctors).orElse(null);
    }
}
