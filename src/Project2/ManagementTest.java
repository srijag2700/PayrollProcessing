package Project2;

import static org.junit.Assert.*;
import org.junit.Test;
import java.text.DecimalFormat;

public class ManagementTest {
    DecimalFormat df = new DecimalFormat("#########0.00");

    @Test
    public void testCalculatePayment() {
        Profile testEmpProf1 = new Profile("Doe,Jane", "CS", new Date("1/1/2020"));
        Management testMgmt1 = new Management(testEmpProf1, 95000, 1);
        testMgmt1.calculatePayment();
        assertEquals("3846.15", df.format(testMgmt1.getPayment())); // test case #1, calculating payment of manager
        Profile testEmpProf2 = new Profile("Gottiparthi,Srija", "ITI", new Date("2/1/2012"));
        Management testMgmt2 = new Management(testEmpProf2, 90000, 2);
        testMgmt2.calculatePayment();
        assertEquals("3826.92", df.format(testMgmt2.getPayment())); // test case #2, calculating payment of department head
        Profile testEmpProf3 = new Profile("Nguyen,Catherine", "ECE", new Date("2/27/2014"));
        Management testMgmt3 = new Management(testEmpProf3, 80000, 3);
        testMgmt3.calculatePayment();
        assertEquals("3538.46", df.format(testMgmt3.getPayment())); // test case #3, calculating payment of director
    }
}