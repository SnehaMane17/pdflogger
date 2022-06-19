package com.silvercloud.pdflogger.repo;

import com.silvercloud.pdflogger.entity.Mockdata;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

public interface MockRepo extends JpaRepository<Mockdata,Integer> {

}

