package com.abhishek.hospital_management_system.controller;

import com.abhishek.hospital_management_system.dto.AddDoctorReview;
import com.abhishek.hospital_management_system.dto.DoctorLoginRequest;
import com.abhishek.hospital_management_system.dto.DoctorLoginResponse;
import com.abhishek.hospital_management_system.dto.DoctorRegisterRequest;
import com.abhishek.hospital_management_system.modal.Doctor;
import com.abhishek.hospital_management_system.service.DoctorService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.print.Doc;
import java.util.Optional;

@RestController
@RequestMapping("/api/doctor")
public class DoctorController {
    @Autowired
    private DoctorService doctorService;

    @PutMapping("/{id}/doctorReview")
    public Optional<Doctor> addDoctorReview(@RequestBody AddDoctorReview addDoctorReview, @PathVariable("id") ObjectId id){
        return doctorService.addDoctorReview(addDoctorReview,id);
    }

    @PostMapping("/doc_login")
    public DoctorLoginResponse doctorLogin(@RequestBody DoctorLoginRequest doctorLoginRequest){
        return doctorService.doctorLogin(doctorLoginRequest);
    }

    @PostMapping("/doc_register")
    public Doctor doctorRegister(@RequestBody DoctorRegisterRequest doctorRegisterRequest){
        return doctorService.doctorRegister(doctorRegisterRequest);
    }
}
