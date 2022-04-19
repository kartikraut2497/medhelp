package com.example.medhelp.services;

import com.example.medhelp.models.Appointement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class PatientService {

    @Autowired
    private DataLoaderService dataLoaderService;

    public Map<String, List<Appointement>> getData(){
        return dataLoaderService.getDoctorScheduleMap();
    }

    public Boolean bookAppointment(Integer pId, Integer appId){
        Appointement appointement = dataLoaderService.getAppointementMap().get(appId);
        if(!appointement.getBooked()){
            Boolean isSlotBooked = false;
            List<Appointement> currentBookings = dataLoaderService.getPatientBookingsMap().get(pId) == null ? new ArrayList<>() : dataLoaderService.getPatientBookingsMap().get(pId);

            if(currentBookings != null) {
                for (Appointement booking : currentBookings) {
                    if (booking.getStartTime() == appointement.getStartTime() && booking.getEndTime() == appointement.getEndTime()) {
                        isSlotBooked = true;
                        break;
                    }
                }
            }

            if(!isSlotBooked){
                appointement.setBooked(true);
                currentBookings.add(appointement);
                dataLoaderService.getPatientBookingsMap().put(pId, currentBookings);
                return true;
            }
        }
        return false;
    }

    public void cancelAppointment(Integer pId, Integer appId) {
        Appointement appointement = dataLoaderService.getAppointementMap().get(appId);
        List<Appointement> currentBookings = dataLoaderService.getPatientBookingsMap().get(pId);
        currentBookings.remove(appointement);
        appointement.setBooked(false);
    }

    public List<Appointement> getBookings(Integer pId){
        return dataLoaderService.getPatientBookingsMap().get(pId);
    }
}
