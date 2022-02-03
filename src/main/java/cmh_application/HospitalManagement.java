package cmh_application;

import java.time.LocalDate;

public class HospitalManagement{
    public static void main(String[] args){
        Hospital hospital = new Hospital();

        LocalDate currentDate = LocalDate.now();
        LocalDate currentDateMinus3Days = currentDate.minusDays(3);
        LocalDate currentDateMinus5Days = currentDate.minusDays(5);

        Patient p1 = new Visit("Patient1", "Bengaluru", currentDate);
        Patient p2 = new Visit("Patient2", "Bengaluru", currentDate);
        Patient p3 = new Visit("Patient3", "Mysuru", currentDate);
        Patient p4 = new Visit("Patient4", "Bengaluru", currentDateMinus5Days);
        Patient p5 = new Visit("Patient5", "Chikmagalore", currentDateMinus5Days);
        Patient p6 = new Visit("Patient6", "Kolar", currentDateMinus3Days);
        hospital.addPatient(p1,p2,p3,p4,p5,p6);

        LocalDate startDate = LocalDate.of(2021, 06, 14);
        LocalDate endDate = LocalDate.of(2021, 06, 23);

        int noOfPatientsBengaluru = hospital.getPatientsFromBengaluru(startDate, endDate).size();
        int noOfPatientsOutOfBengaluru = hospital.getPatientsOutOfBengaluru(startDate, endDate).size();
        int totalNoOfPatients = hospital.getNoOfPatients(startDate, endDate).size();
        double percentage = totalNoOfPatients!=0?(noOfPatientsOutOfBengaluru * 100) / totalNoOfPatients:0;
        double percentageBengaluru = totalNoOfPatients!=0?(noOfPatientsBengaluru * 100) / totalNoOfPatients:0;


        System.out.println("From "+ startDate +" to "+ endDate+", "+ totalNoOfPatients +" OP registrations took place of which "+percentageBengaluru+"% are from bangalore and " +percentage+"% are outstation");
    }
}
