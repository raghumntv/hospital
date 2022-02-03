package cmh_application;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Hospital {
    List<Patient> patientList = new ArrayList<>();
    public void addPatient(Patient... patient) {
        patientList.addAll(Arrays.asList(patient));
    }

    public List<Patient> getPatients() {
        return patientList;
    }

    public List<Patient> getPatientsFromBengaluru(LocalDate startDate, LocalDate endDate){
        List<Patient> patients = getPatients();
        return patients.stream().parallel().filter(patient -> {
            return "Bengaluru".equalsIgnoreCase(patient.getPatientLoc()) && patient.getPatientRegTime().isAfter(startDate)
                    && patient.getPatientRegTime().isBefore(endDate);
        }).collect(Collectors.toList());
    }

    public List<Patient> getPatientsOutOfBengaluru(LocalDate startDate, LocalDate endDate){
        List<Patient> patients = getPatients();
        return patients.stream().parallel().filter(patient -> {
            return !"Bengaluru".equalsIgnoreCase(patient.getPatientLoc()) && patient.getPatientRegTime().isAfter(startDate)
                    && patient.getPatientRegTime().isBefore(endDate);
        }).collect(Collectors.toList());
    }

    public List<Patient> getNoOfPatients(LocalDate startDate, LocalDate endDate){
        List<Patient> patients = getPatients();
        return patients.stream().parallel().filter(patient -> {
            return patient.getPatientRegTime().isAfter(startDate)
                    && patient.getPatientRegTime().isBefore(endDate);
        }).collect(Collectors.toList());
    }
}
