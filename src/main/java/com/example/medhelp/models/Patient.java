package com.example.medhelp.models;

public class Patient {

    int patientId;
    String patientName;
    String patientEmail;

    public Patient(int patientId, String patientName, String patientEmail) {
        this.patientId = patientId;
        this.patientName = patientName;
        this.patientEmail = patientEmail;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPatientEmail() {
        return patientEmail;
    }

    public void setPatientEmail(String patientEmail) {
        this.patientEmail = patientEmail;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "patientId=" + patientId +
                ", patientName='" + patientName + '\'' +
                ", patientEmail='" + patientEmail + '\'' +
                '}';
    }
}
