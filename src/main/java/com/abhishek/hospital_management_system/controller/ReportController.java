package com.abhishek.hospital_management_system.controller;

import com.abhishek.hospital_management_system.modal.User;
import com.abhishek.hospital_management_system.service.ReportService;
import com.sun.net.httpserver.Headers;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;
import java.util.function.Consumer;

@RestController
@RequestMapping("/api/reports")
public class ReportController {
    @Autowired
    private ReportService reportService;

    @PostMapping("/{id}/uploadreport")
    public ResponseEntity<User> uploadReport(@RequestParam("file") MultipartFile file, ObjectId id){
        if(file.isEmpty()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(reportService.uploadReport(file,id));
    }

    @PostMapping("/{id}/downloadreport")
    public ResponseEntity<Resource> downloadReport(ObjectId id){
        Headers headers=new Headers();
        Resource resource=reportService.downloadReport(id);
        headers.add(HttpHeaders.CONTENT_DISPOSITION,"attachment; filename="+resource.getFilename());
        return ResponseEntity.ok().headers((Consumer<HttpHeaders>) headers).body(resource);
    }
}
