package com.example.medhelp.services;

import com.example.medhelp.enums.Speciality;
import com.example.medhelp.models.Appointement;
import com.example.medhelp.models.Doctor;
import com.example.medhelp.models.Patient;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DataLoaderService {

    public Map<Speciality, List<Appointement>> specialitySlotsMap = new HashMap<>();
    public Map<String, List<Appointement>> doctorScheduleMap = new HashMap<>();
    public Map<Integer, List<Appointement>> patientBookingsMap = new HashMap<>();
    public Map<Integer, Appointement> appointmentMap = new HashMap<>();

    public void loadData(){
        Doctor doctor1 = new Doctor(1, "doctor1", Speciality.CARDIOLOGIST);
        Doctor doctor2 = new Doctor(2, "doctor2", Speciality.CARDIOLOGIST);
        Doctor doctor3 = new Doctor(3, "doctor3", Speciality.DERMATOLOGIST);
        Doctor doctor4 = new Doctor(4, "doctor4", Speciality.ORTHOPAEDIC);

        Patient patient1 = new Patient(1, "patient1", "abc@gmail.com");
        Patient patient2 = new Patient(2, "patient2", "def@gmail.com");
        Patient patient3 = new Patient(3, "patient3", "abc@gmail.com");

        Appointement appointement1 = new Appointement(1, 900, 930, doctor1);
        Appointement appointement2 = new Appointement(2, 900, 930, doctor2);
        Appointement appointement3 = new Appointement(3, 1000, 1030, doctor1);
        Appointement appointement4 = new Appointement(4, 1100, 1130, doctor3);
        Appointement appointement5 = new Appointement(5, 1130, 1200, doctor4);
        Appointement appointement6 = new Appointement(6, 1200, 1230, doctor2);

        appointmentMap.put(1, appointement1);
        appointmentMap.put(2, appointement2);
        appointmentMap.put(3, appointement3);
        appointmentMap.put(4, appointement4);
        appointmentMap.put(5, appointement5);
        appointmentMap.put(6, appointement6);

        specialitySlotsMap.put(Speciality.CARDIOLOGIST, Arrays.asList(appointement1, appointement2, appointement3, appointement6));
        specialitySlotsMap.put(Speciality.DERMATOLOGIST, Arrays.asList(appointement4));
        specialitySlotsMap.put(Speciality.ORTHOPAEDIC, Arrays.asList(appointement5));

        doctorScheduleMap.put(doctor1.getDoctorName(), Arrays.asList(appointement1, appointement3));
        doctorScheduleMap.put(doctor2.getDoctorName(), Arrays.asList(appointement2, appointement6));
        doctorScheduleMap.put(doctor3.getDoctorName(), Arrays.asList(appointement4));
        doctorScheduleMap.put(doctor4.getDoctorName(), Arrays.asList(appointement5));
    }

    public Map<Speciality, List<Appointement>> getSpecialitySlotsMap() {
        return specialitySlotsMap;
    }

    public void setSpecialitySlotsMap(Map<Speciality, List<Appointement>> specialitySlotsMap) {
        this.specialitySlotsMap = specialitySlotsMap;
    }

    public Map<String, List<Appointement>> getDoctorScheduleMap() {
        return doctorScheduleMap;
    }

    public void setDoctorScheduleMap(Map<String, List<Appointement>> doctorScheduleMap) {
        this.doctorScheduleMap = doctorScheduleMap;
    }

    public Map<Integer, List<Appointement>> getPatientBookingsMap() {
        return patientBookingsMap;
    }

    public void setPatientBookingsMap(Map<Integer, List<Appointement>> patientBookingsMap) {
        this.patientBookingsMap = patientBookingsMap;
    }

    public Map<Integer, Appointement> getAppointementMap() {
        return appointmentMap;
    }

    public void setAppointementMap(Map<Integer, Appointement> appointementMap) {
        this.appointmentMap = appointementMap;
    }

    public List<Appointement> getAllAppointments(){
        List<Appointement> appointementList = new ArrayList<>();
        for(Map.Entry<Integer, Appointement> appointementEntry: appointmentMap.entrySet()){
            appointementList.add(appointementEntry.getValue());
        }

        return appointementList;
    }
}
