package com.example.medhelp.controllers;

import com.example.medhelp.enums.Speciality;
import com.example.medhelp.models.Appointement;
import com.example.medhelp.services.DataLoaderService;
import com.example.medhelp.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @PostMapping("/bookAppointment/{pId}/{appId}")
    public Boolean bookAppointment(@PathVariable Integer pId, @PathVariable Integer appId){
        return patientService.bookAppointment(pId, appId);
    }

    @PostMapping("/cancel/{pId}/{appId}")
    public void cancelAppointment(@PathVariable Integer pId, @PathVariable Integer appId){
        patientService.cancelAppointment(pId, appId);
    }

    @GetMapping("/getBookings/{pId}")
    public List<Appointement> getBookings(@PathVariable Integer pId){
        return patientService.getBookings(pId);
    }

}
