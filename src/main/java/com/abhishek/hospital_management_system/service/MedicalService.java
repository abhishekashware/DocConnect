package com.abhishek.hospital_management_system.service;

import com.abhishek.hospital_management_system.modal.Medicine;
import com.abhishek.hospital_management_system.dto.SaveMedicineRequest;
import com.abhishek.hospital_management_system.repository.MedicalRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicalService {
    @Autowired
    private MedicalRepository medicalRepository;

    public Medicine saveMedicine(SaveMedicineRequest saveMedicineRequest) {
        return medicalRepository.save(new Medicine(new ObjectId().toHexString(),saveMedicineRequest.getName(),saveMedicineRequest.getAka(),saveMedicineRequest.getWeight(),saveMedicineRequest.getCost(),saveMedicineRequest.getField(),"",saveMedicineRequest.getDetails(),""));
    }

    public List<Medicine> getAllMedicines() {
        return medicalRepository.findAll();
    }

    public Optional<Medicine> findMedicineById(ObjectId objectId) {
        return medicalRepository.findById(objectId);
    }
}
