package com.silvercloud.pdflogger.repo;

import com.silvercloud.pdflogger.entity.Mockdata;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MockRepo extends JpaRepository<Mockdata,Integer> {

}
