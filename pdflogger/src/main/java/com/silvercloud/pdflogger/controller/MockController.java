package com.silvercloud.pdflogger.controller;

import com.silvercloud.pdflogger.entity.Mockdata;
import com.silvercloud.pdflogger.helper.Helper;
import com.silvercloud.pdflogger.service.MockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("*")
public class MockController {
    @Autowired
    private MockService mockService;

    @PostMapping("/mockdata/upload")
    public ResponseEntity<?> upload(@RequestParam("file")MultipartFile file){
        if(Helper.checkExcelFormat(file))
        {
            //true
            this.mockService.save(file);
            return ResponseEntity.ok(Map.of("message","File uploaded and data is saved to DB"));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Pleas upload Excel file only");
    }

    @GetMapping("/mockdata")
    public List<Mockdata> getAllMockData(){
        return this.mockService.getAllMockdata();
    }
}
