package com.silvercloud.pdflogger.service;

import com.silvercloud.pdflogger.entity.Mockdata;
import com.silvercloud.pdflogger.helper.Helper;
import com.silvercloud.pdflogger.repo.MockRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Service
public class MockService {

    private final Helper helper;


    @Autowired
    private MockRepo mockRepo ;


    public MockService() {
        helper = new Helper();
    }

    public void save(MultipartFile file) {
        try {

            List<Mockdata> mockdata = helper.convertExcelToListOfMockdata(file.getInputStream());
            this.mockRepo.saveAll(mockdata);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Mockdata> getAllMockdata() {
        return this.mockRepo.findAll();
    }
}
