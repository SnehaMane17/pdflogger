package com.silvercloud.pdflogger.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MockData {
    @Id
    private Integer id;
    private String time;
    private  Float temperature;

    public MockData(Integer id, String time, Float temperature) {
        this.id = id;
        this.time = time;
        this.temperature = temperature;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Float getTemperature() {
        return temperature;
    }

    public void setTemperature(Float temperature) {
        this.temperature = temperature;
    }


}
