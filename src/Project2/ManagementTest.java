package Project2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.text.DecimalFormat;

public class ManagementTest {
    DecimalFormat df = new DecimalFormat("$#,###,###,##0.00");

    @Test
    public void testToString() {
        Profile testEmpProf1 = new Profile("Doe,Jane", "CS", new Date("1/1/2020"));
        Management testMgmt1 = new Management(testEmpProf1, 95000, "Manager");
        assertEquals("Doe,Jane::CS::1/1/2020::Payment $3,653.85::FULL TIME::Annual Salary $95,000.00::" +
                "Manager Compensation $192.31", testMgmt1.toString());
        Profile testEmpProf2 = new Profile("Gottiparthi,Srija", "ITI", new Date("2/1/2012"));
        Management testMgmt2 = new Management(testEmpProf2, 90000, "DepartmentHead");
        assertEquals("Gottiparthi, Srija::ITI::2/1/2012::Payment $3,461.54::FULL TIME::Annual Salary $90,000.00::" +
                "DepartmentHead Compensation $365.38", testMgmt2.toString());
        Profile testEmpProf3 = new Profile("Nguyen,Catherine", "ECE", new Date("2/27/2014"));
        Management testMgmt3 = new Management(testEmpProf3, 80000, "Director");
        assertEquals("Nguyen,Catherine::ECE::2/27/2014::Payment $3,076.92::FULL TIME::Annual Salary $80,000.00::" +
                "Director Compensation $461.54", testMgmt3.toString());
    }

    @Test
    public void testEquals() {
        Profile testEmpProf1 = new Profile("Doe,Jane", "CS", new Date("1/1/2020"));
        Management testMgmt1 = new Management(testEmpProf1, 95000, "Manager");
        Profile testEmpProf2 = new Profile("Doe,Jane", "CS", new Date("1/1/2020"));
        Management testMgmt2 = new Management(testEmpProf2, 95000, "Manager");
        assertEquals(true, testMgmt1.equals(testMgmt2));
        Profile testEmpProf3 = new Profile("Doe,Jane", "CS", new Date("1/1/2020"));
        Management testMgmt3 = new Management(testEmpProf3, 95000, "Director");
        assertEquals(false, testMgmt1.equals(testMgmt3));
    }

    @Test
    public void testCalculatePayment() {
        Profile testEmpProf1 = new Profile("Doe,Jane", "CS", new Date("1/1/2020"));
        Management testMgmt1 = new Management(testEmpProf1, 95000, "Manager");
        testMgmt1.calculatePayment();
        assertEquals(3846.15, testMgmt1.getPayment());
    }
}