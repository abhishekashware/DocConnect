package com.abhishek.hospital_management_system.controller;

import com.abhishek.hospital_management_system.dto.AddMedicineRequest;
import com.abhishek.hospital_management_system.dto.ApproveAppointmentRequest;
import com.abhishek.hospital_management_system.dto.FollowUpRequest;
import com.abhishek.hospital_management_system.dto.SetAppointmentRequest;
import com.abhishek.hospital_management_system.modal.Appointment;
import com.abhishek.hospital_management_system.modal.Hospital;
import com.abhishek.hospital_management_system.service.AppointmentService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/userAppointment")
public class AppointmentController {
    @Autowired
    private AppointmentService appointmentService;

    @PostMapping("/{id}/medicineDetails")
    public Optional<Appointment> addMedicineDetailsToAppointment(@RequestBody AddMedicineRequest addMedicineRequest, @PathVariable("id")  ObjectId id){
        return appointmentService.addMedicineDetailsToAppointment(addMedicineRequest,id);
    }


    @PostMapping("/{id}/followUp")
    public Optional<Appointment> followUpAppointment(@RequestBody FollowUpRequest followUpRequest, @PathVariable("id")  ObjectId id){
        return appointmentService.followUpAppointment(followUpRequest,id);
    }

    @GetMapping("/{id}/myAppointments")
    public List<Appointment> getMyAppointments(@PathVariable("id")  ObjectId id){
        return appointmentService.getMyAppointments(id);
    }

    @GetMapping("/{id}/approvedList")
    public List<Appointment> getApprovedAppointments(@PathVariable("id")  ObjectId id){
        return appointmentService.getApprovedAppointments(id);
    }


    @PutMapping("/{id}/rejected")
    public Optional<Appointment> rejectAppointment(@PathVariable("id")  ObjectId id){
        return appointmentService.rejectAppointment(id);
    }

    @PutMapping("/{id}/approved")
    public Optional<Appointment> approveAppointment(@RequestBody ApproveAppointmentRequest appointmentRequest, @PathVariable("id") ObjectId id){
        return appointmentService.approveAppointment(appointmentRequest,id);
    }
    @GetMapping("/{id}/appointment/oneappointment")
    public Optional<Appointment> getAppointmentDetails(@PathVariable("id")  ObjectId appointmentId){
        return appointmentService.getAppointmentDetails(appointmentId);
    }

    @GetMapping("/{id}/appointment/hospitalallappointments")
    public List<Appointment> getAllAppointmentsByHospitalId(@PathVariable("id")  ObjectId hospitalId){
        return appointmentService.getAllAppointmentsByHospitalId(hospitalId);
    }

    @PostMapping("/{id}/appointment/setappointment/")
    public Appointment setAppointment(@RequestBody SetAppointmentRequest appointment, @PathVariable("id")  ObjectId hospitalId){
        return appointmentService.setAppointment(appointment,hospitalId);
    }
}
