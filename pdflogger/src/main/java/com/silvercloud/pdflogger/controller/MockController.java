package com.silvercloud.pdflogger.controller;

import com.silvercloud.pdflogger.entity.MockData;
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
        if(Helper.checkExcelFormat(file)){
            //true
            this.mockService.save(file);
            return  ResponseEntity.ok(Map.of("Message","File uploaded successfully and data saved to db"));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please upload the excel file only");
    }
    @GetMapping("/mockdata")
    public List<MockData> getAllMockData(){
        return this.mockService.getAllMockData();
    }

}
