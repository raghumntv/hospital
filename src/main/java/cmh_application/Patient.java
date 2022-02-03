package cmh_application;
import java.time.LocalDate;

public abstract class Patient {
    private String patientName;
    private String patientLoc;
    private LocalDate patientRegTime;

    public Patient(String patientName, String patientLoc, LocalDate patientRegTime) {
        this.patientName = patientName;
        this.patientLoc = patientLoc;
        this.patientRegTime = patientRegTime;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPatientLoc() {
        return patientLoc;
    }

    public void setPatientLoc(String patientLoc) {
        this.patientLoc = patientLoc;
    }

    public LocalDate getPatientRegTime() {
        return patientRegTime;
    }

    public void setPatientRegTime(LocalDate patientRegTime) {
        this.patientRegTime = patientRegTime;
    }
}
