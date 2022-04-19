package com.example.medhelp.models;

public class Appointement {

    int appointementId;
    int startTime;
    int endTime;
    Doctor doctor;
    Boolean isBooked = false;

    public Appointement(int appointementId, int startTime, int endTime, Doctor doctor) {
        this.appointementId = appointementId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.doctor = doctor;
    }

    public int getAppointementId() {
        return appointementId;
    }

    public void setAppointementId(int appointementId) {
        this.appointementId = appointementId;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Boolean getBooked() {
        return isBooked;
    }

    public void setBooked(Boolean booked) {
        isBooked = booked;
    }

    @Override
    public String toString() {
        return "Appointement{" +
                "appointementId=" + appointementId +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", doctor=" + doctor +
                ", isBooked=" + isBooked +
                '}';
    }
}
