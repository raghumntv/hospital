package cmh_application;
import java.time.LocalDate;

public class Visit extends Patient {
    public Visit(String patientName, String patientLoc, LocalDate patientRegTime) {
        super(patientName, patientLoc, patientRegTime);
    }
}
