package com.silvercloud.pdflogger.repo;

import com.silvercloud.pdflogger.entity.MockData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MockRepo extends JpaRepository <MockData, Integer> {
}
