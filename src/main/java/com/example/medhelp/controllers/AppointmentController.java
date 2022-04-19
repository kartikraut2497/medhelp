package com.example.medhelp.controllers;

import com.example.medhelp.enums.Speciality;
import com.example.medhelp.models.Appointement;
import com.example.medhelp.services.DataLoaderService;
import com.example.medhelp.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    @Autowired
    private DataLoaderService dataLoaderService;

    @Autowired
    private PatientService patientService;

    @GetMapping("/loadData")
    public void loadData(){
        dataLoaderService.loadData();
    }

    @GetMapping("/getAll")
    public List<Appointement> getAllAppointments(){
       return dataLoaderService.getAllAppointments();
    }

    @GetMapping("/searchBySpeciality/{speciality}")
    public List<Appointement> getAppointmentsBySpeciality(@PathVariable String speciality){
        Speciality specialityEnum = Speciality.valueOf(speciality);
        return dataLoaderService.getSpecialitySlotsMap().get(specialityEnum);
    }

    @GetMapping("/searchByDoctor/{doctorName}")
    public List<Appointement> getAppointmentsByDoctorName(@PathVariable String doctorName){
        return dataLoaderService.getDoctorScheduleMap().get(doctorName);
    }

    @GetMapping("/getData")
    public Map<String, List<Appointement>> getData(){
        return patientService.getData();
    }
}
