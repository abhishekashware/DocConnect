package com.abhishek.hospital_management_system.controller;

import com.abhishek.hospital_management_system.modal.Medicine;
import com.abhishek.hospital_management_system.dto.SaveMedicineRequest;
import com.abhishek.hospital_management_system.service.MedicalService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/medic")
public class MedicalController {
    @Autowired
    private MedicalService medicalService;

    @PostMapping("/newmedicine")
    public Medicine saveMedicine(@RequestBody SaveMedicineRequest saveMedicineRequest){
        return medicalService.saveMedicine(saveMedicineRequest);
    }

    @GetMapping("/allmedicine")
    public List<Medicine> getAllMedicines(){
        return medicalService.getAllMedicines();
    }

    @GetMapping("/{id}")
    public Optional<Medicine> findMedicineById(@PathVariable("id") ObjectId objectId){
        return medicalService.findMedicineById(objectId);
    }
}
