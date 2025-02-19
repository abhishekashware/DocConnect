package com.abhishek.hospital_management_system.service;

import com.abhishek.hospital_management_system.modal.User;
import com.abhishek.hospital_management_system.repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class ReportService {
    @Autowired
    private UserRepository userRepository;

    private static final String UPLOAD_PATH="uploads/reports/";

    public User uploadReport(MultipartFile file, ObjectId id){
        Optional<User> user=userRepository.findById(id);
        if(user.isPresent()){
            try {
                File uploadDir = new File(UPLOAD_PATH);
                if (!uploadDir.exists() && !uploadDir.mkdirs()) {
                    return null;
                }
                File uploadedFile=new File(UPLOAD_PATH+ id.toString() + file.getName());
                FileOutputStream fileOutputStream=new FileOutputStream(uploadedFile);
                fileOutputStream.write(file.getBytes());
                user.get().getReport().add(uploadedFile.getName());
            }catch (Exception e){
                System.out.println(e.getMessage());
                return null;
            }

            return user.get();
        }
        return null;
    }

    public Resource downloadReport(ObjectId id){
        Optional<User> user=userRepository.findById(id);
        if(user.isPresent()){
            try {
                List<String> reportList=user.get().getReport();
                if(reportList.size()>0){
                    File file=new File(UPLOAD_PATH+reportList.get(0));
                    Resource resource=new FileSystemResource(file);
                    return resource;
                }
            }catch (Exception e){
                System.out.println(e.getMessage());
                return null;
            }
        }
        return null;
    }
}
