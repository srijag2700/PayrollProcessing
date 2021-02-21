package Project2;
import java.lang.NullPointerException;

public class Company {
    private Employee[] emplist;
    private int numEmployee;
    private final static int CAPACITY = 4;
    private final static int NOT_FOUND = -1;

    public Company() {
        numEmployee = 0;
        emplist = new Employee[CAPACITY];
    }

    private int find(Employee employee) {
        for (int i = 0; i < emplist.length; i++) {
            if (emplist[i].equals(employee)) {
                return i; // returns index of employee
            }
        }
        return NOT_FOUND;
    }

    private void grow() {
        int currentLength = emplist.length;
        int newLength = currentLength + CAPACITY;

        Employee[] tempEmp = new Employee[newLength];

        // copy over all current employees
        for (int i = 0; i < currentLength; i++) {
            tempEmp[i] = emplist[i];
        }

        emplist = tempEmp;
    }
    public boolean add(Employee employee) {
        if (numEmployee == emplist.length) {
            grow();
        }

        if (find(employee) != NOT_FOUND) {
            return false;
        }

        emplist[numEmployee] = employee;
        numEmployee++;
        return true;
    } //check the profile before adding

    public boolean remove(Employee employee) {

        int empIndex = find(employee);
        if (empIndex == NOT_FOUND) {
            return false;
        }

        Employee[] tempEmp = new Employee[emplist.length-1];
        for (int i = 0, j = 0; i < emplist.length; i++) {
            if (!emplist[i].equals(employee)) {
                tempEmp[j++] = emplist[i];
            }
        }
        emplist = tempEmp;
        numEmployee--;
        return true;
    } //maintain the original sequence

    public boolean setHours(Employee employee) {
        // make temporary employee in payrollprocessing with those hours & pass it into this method

        int empIndex = find(employee);
        if (empIndex == NOT_FOUND) {
            return false;
        }
        Parttime partTimeEmployee = (Parttime) employee;
        Parttime tempPartTime = (Parttime) emplist[empIndex];
        tempPartTime.setHoursWorked(partTimeEmployee.getHoursWorked());
        emplist[empIndex] = tempPartTime;
        return true;

    } //set working hours for a part time

    public void processPayments() {
        if (numEmployee == 0) {
            throw new NullPointerException("Employee database is empty.");
        }
        for (int i = 0; i < emplist.length; i++) {
            emplist[i].calculatePayment();
        }
    } //process payments for all employees

    public void print() {
        if (numEmployee == 0) {
            System.out.println("Employee database is empty.");
            return;
        }
        System.out.println("--Printing earning statements for all employees--");
        for (int i = 0; i < emplist.length; i++) {
            if (emplist[i] != null) {
                System.out.println(emplist[i]);
            }
        }
    } //print earning statements for all employees

    public void printByDepartment() {
        if (numEmployee == 0) {
            System.out.println("Employee database is empty.");
            return;
        }
        insertionSortByCompany();
        System.out.println("**List of books by the book numbers.");
        for (int i = 0; i < emplist.length; i++) {
            System.out.println(emplist[i]);
        }
    } //print earning statements by department

    public void printByDate() {
        if (numEmployee == 0) {
            System.out.println("Employee database is empty.");
            return;
        }
        insertionSortByDate();
        System.out.println("--Printing earning statements by date hired--");
        for (int i = 0; i < emplist.length; i++) {
            System.out.println(emplist[i]);
        }
    } //print earning statements by date hired

    private void insertionSortByCompany() {
        for (int i = 0; i < emplist.length; i++) {
            Employee currEmp = emplist[i];
            String currDept = currEmp.getEmployeeProfile().getDepartment();
            int j = i - 1;
            while (j >= 0 && currDept.compareTo(emplist[j].getEmployeeProfile().getDepartment()) < 0) {
                emplist[j+1] = emplist[j];
                j--;
            }
            emplist[j+1] = currEmp;
        }
    }

    private void insertionSortByDate() {
        for (int i = 0; i < emplist.length; i++) {
            Employee currEmp = emplist[i];
            Date currDate = currEmp.getEmployeeProfile().getDateHired();
            int j = i - 1;
            while (j >= 0 && currDate.compareTo(emplist[j].getEmployeeProfile().getDateHired()) <= 0) {
                emplist[j+1] = emplist[j];
                j--;
            }
            emplist[j+1] = currEmp;

        }
    }
}