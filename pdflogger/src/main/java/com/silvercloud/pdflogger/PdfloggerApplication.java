package com.silvercloud.pdflogger;

import com.silvercloud.pdflogger.controller.MockController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.IOException;

@SpringBootApplication
public class PdfloggerApplication {

	public static void main(String[] args) {
		SpringApplication.run(PdfloggerApplication.class, args);
		MultipartFile initialFile = null;
		try {
			initialFile = new MockMultipartFile("MOCK_DATA (1).xlsx","MOCK_DATA (1).xlsx","application/vnd.openxmlformats-officedocument.spreadsheetml.sheet",
					new FileInputStream("D:\\pdflogger\\pdflogger\\src\\main\\resources\\MOCK_DATA (1).xlsx"));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		MockController mockController = new MockController();
		mockController.upload(initialFile);

	}

}
