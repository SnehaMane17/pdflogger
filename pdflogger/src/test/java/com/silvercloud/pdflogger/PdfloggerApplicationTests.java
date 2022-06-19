package com.silvercloud.pdflogger;

import com.silvercloud.pdflogger.controller.MockController;
import com.silvercloud.pdflogger.helper.Helper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

@SpringBootTest
class PdfloggerApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test

    void apiTest() throws FileNotFoundException {

        MultipartFile initialFile = null;
        try {
            initialFile = new MockMultipartFile("MOCK_DATA (1).xlsx","MOCK_DATA (1).xlsx","application/vnd.openxmlformats-officedocument.spreadsheetml.sheet", new FileInputStream("src/test/resources/MOCK_DATA (1).xlsx"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        MockController mockController = new MockController();
        mockController.upload(initialFile);

    }
}
