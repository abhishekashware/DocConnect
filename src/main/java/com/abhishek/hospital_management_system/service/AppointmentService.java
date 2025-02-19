package com.abhishek.hospital_management_system.service;

import com.abhishek.hospital_management_system.dto.AddMedicineRequest;
import com.abhishek.hospital_management_system.dto.ApproveAppointmentRequest;
import com.abhishek.hospital_management_system.dto.FollowUpRequest;
import com.abhishek.hospital_management_system.dto.SetAppointmentRequest;
import com.abhishek.hospital_management_system.modal.*;
import com.abhishek.hospital_management_system.repository.AppointmentRepository;
import com.abhishek.hospital_management_system.repository.DoctorRepository;
import com.abhishek.hospital_management_system.repository.HospitalRepository;
import com.abhishek.hospital_management_system.repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {
    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private HospitalRepository hospitalRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private UserRepository userRepository;

//    public Appointment scheduleAppointment(Appointment appointment,ObjectId hospitalId){
//        Optional<Hospital> hospital=hospitalRepository.findById(hospitalId);
//                if(hospital.isPresent()){
//                    List<Appointment> appointments=hospital.get().getAppointments();
//                    appointments.add(appointment);
//                    hospital.get().setAppointments(appointments);
//                    return appointmentRepository.save(appointment);
//                }
//        return null;
//    }

    public List<Appointment> getAppointmentsByHospitalId(ObjectId id){
        Optional<Hospital> hospital=hospitalRepository.findById(id);
        if(hospital.isPresent()){
            return hospital.get().getAppointments();
        }
        return null;
    }

    public Optional<Appointment> getAppointmentDetails(ObjectId id){
        return appointmentRepository.findById(id);
    }

    public Optional<Appointment>  approveAppointment(ApproveAppointmentRequest appointmentRequest, ObjectId id) {
        Optional<Appointment> appointment=appointmentRepository.findById(id);
        Optional<Doctor> doctor=doctorRepository.findById(appointmentRequest.getAssignedDoc());
        AppointmentStatus appointmentStatus=new AppointmentStatus(false,true,false);
        if(appointment.isPresent() && doctor.isPresent()){
            Appointment a=appointment.get();
            a.setStatus(appointmentStatus);
            a.setAppointDate(appointmentRequest.getDate());
            a.setToken(appointmentRequest.getToken());
            a.setAssignedDoctor(doctor.get());
            a.setAppointDate(appointmentRequest.getDate());
            appointmentRepository.save(a);
        }
        return appointment;
    }

    public Optional<Appointment> rejectAppointment(ObjectId id) {
        Optional<Appointment> appointment=appointmentRepository.findById(id);
        if(appointment.isPresent()){
            Appointment a=appointment.get();
            AppointmentStatus appointmentStatus=new AppointmentStatus(false,false,true);
            a.setStatus(appointmentStatus);
            appointmentRepository.save(a);
        }
        return appointment;
    }

    public List<Appointment> getApprovedAppointments(ObjectId id) {
        return appointmentRepository.findByStatus(new AppointmentStatus(false,true,false));
    }

    public List<Appointment> getMyAppointments(ObjectId id) {

        Optional<User> user=userRepository.findById(id);
        List<Appointment> appointments=appointmentRepository.findByPatient(user.get());
        return appointments;
    }

    public Optional<Appointment> followUpAppointment(FollowUpRequest followUpRequest, ObjectId id) {

        Optional<Doctor> doctor=doctorRepository.findById(followUpRequest.getDoctorId());
        Optional<Appointment> appointment=appointmentRepository.findById(id);
        if(doctor.isPresent() && appointment.isPresent()){
            Appointment a=appointment.get();
            a.setFollowUp(followUpRequest.getFollowUp());
            a.setToken(followUpRequest.getToken());
            a.setDocArrival(followUpRequest.getDoctime());
            a.setStatus(new AppointmentStatus(false,true,false));
            appointmentRepository.save(a);
        }
        return appointment;
    }

    public Optional<Appointment> addMedicineDetailsToAppointment(AddMedicineRequest addMedicineRequest, ObjectId id) {
        Optional<Appointment> appointment=appointmentRepository.findById(id);
        if(appointment.isPresent()){
            Appointment a=appointment.get();
            a.getMedicines().add(new Medicine(new ObjectId().toHexString(), addMedicineRequest.getDesc(), addMedicineRequest.getDesc(),"100mg",100,"","","",""));
            appointmentRepository.save(a);
        }
        return appointment;
    }

    public List<Appointment> getAllAppointmentsByHospitalId(ObjectId hospitalId) {
        Optional<Hospital> hospital=hospitalRepository.findById(hospitalId);
        if(hospital.isPresent()){
            return hospital.get().getAppointments();
        }
        return null;
    }

    public Appointment setAppointment(SetAppointmentRequest appointmentRequest, ObjectId hospitalId) {
        Optional<Hospital> hospital=hospitalRepository.findById(hospitalId);
        Optional<User> user=userRepository.findById(appointmentRequest.getPatient());
        if (hospital.isPresent() && user.isPresent()){
            Hospital h=hospital.get();
            Appointment appointment=new Appointment(new ObjectId().toHexString(),appointmentRequest.getName()
                    ,appointmentRequest.getServices(),appointmentRequest.getLocation(),appointmentRequest.getDesc(),appointmentRequest.getContact(),appointmentRequest.getDate(),"","","",
                    appointmentRequest.getAge(),null,false,null,new Date(),h,user.get(),false,false,false,new ArrayList<>());
            appointment.setWithHospital(h);
            h.getAppointments().add(appointment);
            hospitalRepository.save(h);
            appointmentRepository.save(appointment);
            return appointment;
        }
        return null;
    }
}
