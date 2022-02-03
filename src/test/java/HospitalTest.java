import cmh_application.Hospital;
import cmh_application.Patient;
import cmh_application.Visit;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.util.List;

public class HospitalTest {
    Hospital hospital = new Hospital();
    Patient p1, p2, p3, p4, p5;
    long noOfPatientsBengaluru, noOfPatientsOutOfBengaluru, totalPatients;

    @BeforeClass
    public void CreatePatients() {
        p1 = new Visit("P1", "Bengaluru", LocalDate.of(2021,06,21));
        p2 = new Visit("P2", "Mysuru", LocalDate.of(2021,06,21));
        p3 = new Visit("P3", "Kolar", LocalDate.of(2021,06,20));
        p4 = new Visit("P4", "Bengaluru", LocalDate.of(2021,06,19));
        p5 = new Visit("P5", "Mysuru", LocalDate.of(2021,06,20));
        hospital.addPatient(p1, p2, p3, p4, p5);
    }

    @Test
    public void Test001_Patients_Admitted() {
        List<Patient> patients = hospital.getPatients();
        Assert.assertEquals(patients.size(), 5);
        Reporter.log("Total patients admitted: 5", true);
    }

    @Test
    public void Test002_Verify_Patient_Is_Local() {
        Patient p6 = new Visit("P6", "Bengaluru", LocalDate.of(2021,06,20));
        hospital.addPatient(p6);
        Assert.assertEquals(p6.getPatientLoc(), "Bengaluru");
        Reporter.log("Patient:" +p6.getPatientName()+" is a local");
    }
    @Test
    public void Test003_Verify_Patient_Is_Not_Local() {
        Patient p7 = new Visit("P7", "Mysuru", LocalDate.of(2021,06,20));
        hospital.addPatient(p7);
        int count = hospital.getPatients().size();
        Assert.assertNotEquals(p7.getPatientLoc(), "Bengaluru");
        Reporter.log("Patient:" +p7.getPatientName()+" is local");
    }

    @Test
    public void Test004_Verify_Count_Of_Local_Patients() {
        noOfPatientsBengaluru = hospital.getPatientsFromBengaluru(LocalDate.of(2021,06,14), LocalDate.of(2021,06,23)).size();
        Assert.assertEquals(noOfPatientsBengaluru, 3);
        Reporter.log("Number of patients from Bengaluru are 3",true);
    }

    @Test
    public void Test005_Verify_Count_Of_OutStation_Patients() {
        noOfPatientsOutOfBengaluru = hospital.getPatientsOutOfBengaluru(LocalDate.of(2021,06,14), LocalDate.of(2021,06,23)).size();
        Assert.assertEquals(noOfPatientsOutOfBengaluru, 4);
        Reporter.log("Number of patients out of Bengaluru are 4",true);
    }

    @Test
    public void Test006_Verify_Count_Of_Total_Patients() {
        totalPatients = hospital.getNoOfPatients(LocalDate.of(2021,06,14), LocalDate.of(2021,06,23)).size();
        Assert.assertEquals(totalPatients, 7);
        Reporter.log("Total no. of patients admitted are 7",true);
    }

    @Test
    public void Test007_Verify_Percentage_Of_Outstation_Patients() {
        Assert.assertEquals(totalPatients!=0?(noOfPatientsOutOfBengaluru * 100) / totalPatients:0, 57);
        Reporter.log("Percentage of outstation patients is 57%",true);

    }
}