package com.example.medhelp.models;

import com.example.medhelp.enums.Speciality;

public class Doctor {

    int doctorId;
    String doctorName;
    Speciality doctorSpeciality;

    public Doctor(int doctorId, String doctorName, Speciality doctorSpeciality) {
        this.doctorId = doctorId;
        this.doctorName = doctorName;
        this.doctorSpeciality = doctorSpeciality;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public Speciality getDoctorSpeciality() {
        return doctorSpeciality;
    }

    public void setDoctorSpeciality(Speciality doctorSpeciality) {
        this.doctorSpeciality = doctorSpeciality;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "doctorId=" + doctorId +
                ", doctorName='" + doctorName + '\'' +
                ", doctorSpeciality=" + doctorSpeciality +
                '}';
    }
}
