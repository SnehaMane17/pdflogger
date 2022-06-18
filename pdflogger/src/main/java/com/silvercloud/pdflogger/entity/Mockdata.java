package com.silvercloud.pdflogger.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Mockdata {

    @Id
    private Integer id;
    private String time;
    private float temperature;

    public Mockdata() {
    }

    public Mockdata(Integer id, String time, float temperature) {
        this.id = id;
        this.time = time;
        this.temperature = temperature;
    }

    @Override
    public String toString() {
        return "Mockdata{" +
                "id=" + id +
                ", time='" + time + '\'' +
                ", temperature=" + temperature +
                '}';
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

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }
}
