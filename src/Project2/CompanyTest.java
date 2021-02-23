package Project2;

import static org.junit.Assert.*;
import org.junit.Test;

public class CompanyTest {
    Company testCom = new Company();

    @Test
    public void testAdd() {
        Profile testEmpProf1 = new Profile("Doe,Jane", "CS", new Date("1/1/2020"));
        Fulltime testFull1 = new Fulltime(testEmpProf1, 80000);
        assertTrue(testCom.add(testFull1)); // test case #1, adding fulltime
        assertFalse(testCom.add(testFull1)); // test case #2, adding existing fulltime
        Profile testEmpProf2 = new Profile("Meow,Meow", "ITI", new Date("12/31/2020"));
        Parttime testPart2 = new Parttime(testEmpProf2, 30);
        assertTrue(testCom.add(testPart2)); // test case #3, adding parttime
        assertFalse(testCom.add(testPart2)); // test case #4, adding existing parttime
        Profile testEmpProf3 = new Profile("Nguyen,Catherine", "ECE", new Date("2/27/2014"));
        Management testMgmt3 = new Management(testEmpProf3, 80000, 3);
        assertTrue(testCom.add(testMgmt3)); // test case #5, adding management
        assertFalse(testCom.add(testMgmt3)); // test case #6, adding existing management
    }

    @Test
    public void testRemove() {
        Profile testEmpProf1 = new Profile("Doe,Jane", "CS", new Date("1/1/2020"));
        Fulltime testFull1 = new Fulltime(testEmpProf1, 80000);
        testCom.add(testFull1);
        assertTrue(testCom.remove(testFull1)); // test case #1, removing fulltime
        assertFalse(testCom.remove(testFull1)); // test case #2, removing nonexistent fulltime
        Profile testEmpProf2 = new Profile("Meow,Meow", "ITI", new Date("12/31/2020"));
        Parttime testPart2 = new Parttime(testEmpProf2, 30);
        testCom.add(testPart2);
        assertTrue(testCom.remove(testPart2)); // test case #3, removing parttime
        assertFalse(testCom.remove(testPart2));  // test case #4, removing nonexistent parttime
        Profile testEmpProf3 = new Profile("Nguyen,Catherine", "ECE", new Date("2/27/2014"));
        Management testMgmt3 = new Management(testEmpProf3, 80000, 3);
        testCom.add(testMgmt3);
        assertTrue(testCom.remove(testMgmt3));  // test case #5, removing management
        assertFalse(testCom.remove(testMgmt3)); // test case #6, removing nonexistent management
    }

    @Test
    public void testSetHours() {
        Profile testEmpProf1 = new Profile("Meow,Meow", "ITI", new Date("12/31/2020"));
        Parttime testPart1 = new Parttime(testEmpProf1, 30);
        assertFalse(testCom.setHours(testPart1)); // test case #1 set hours when employee database is empty
        testCom.add(testPart1);
        assertTrue(testCom.setHours(testPart1)); // test case #2 set hours of employee
        Profile testEmpProf2 = new Profile("Bark,Bark", "CS", new Date("1/2/2012"));
        Parttime testPart2 = new Parttime(testEmpProf2, 40);
        assertFalse(testCom.setHours(testPart2)); // test case #3 set hours when employee not found
    }
}