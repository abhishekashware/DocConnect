package com.abhishek.hospital_management_system.controller;

import com.abhishek.hospital_management_system.dto.HospitalRegisterRequest;
import com.abhishek.hospital_management_system.modal.Hospital;
import com.abhishek.hospital_management_system.dto.HospitalLoginRequest;
import com.abhishek.hospital_management_system.service.HospitalService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/hospitals")
public class HospitalController {
    @Autowired
    private HospitalService hospitalService;


    @PostMapping("/registerHospital")
    public Hospital registerHospital(@RequestBody HospitalRegisterRequest hospitalRegisterRequest){
        return hospitalService.registerHospital(hospitalRegisterRequest);

    }

    @PostMapping("/loginHospital")
    public Optional<Hospital> loginHospital(@RequestBody HospitalLoginRequest hospitalLoginRequest){
        return hospitalService.loginHospital(hospitalLoginRequest);
    }

    @GetMapping("/allHospital")
    public List<Hospital> getAllHospitals(){
        return hospitalService.getAllHospitals();
    }

    @GetMapping("/{id}")
    public Optional<Hospital> getHospitalById(@PathVariable("id") ObjectId id){
        return hospitalService.getHospitalById(id);
    }

    @PostMapping("/{id}/updateHospital")
    public Optional<Hospital> updateHospital(@RequestBody Hospital hospitalUpdateRequest,@PathVariable("id") ObjectId id){
        return hospitalService.updateHospital(hospitalUpdateRequest,id);
    }

}
