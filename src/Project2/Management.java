package Project2;
import java.text.DecimalFormat;

public class Management extends Fulltime{
    private String managementRole;
    private double addtlCompensation;
    private final static int MANAGER = 1;
    private final static int DEPT_HEAD = 2;
    private final static int DIRECTOR = 3;
    private final static int MANAGER_COMP = 5000;
    private final static int DEPT_HEAD_COMP = 9500;
    private final static int DIRECTOR_COMP = 12000;
    DecimalFormat df = new DecimalFormat("$#,###,###,##0.00");

    public Management(Profile employeeProfile, double salary, int managementStatus) {
        super(employeeProfile, salary);
        if (managementStatus == MANAGER) {
            managementRole = "Manager";
            addtlCompensation = MANAGER_COMP;
        }
        else if (managementStatus == DEPT_HEAD) {
            managementRole = "DepartmentHead";
            addtlCompensation = DEPT_HEAD_COMP;
        }
        else if (managementStatus == DIRECTOR) {
            managementRole = "Director";
            addtlCompensation = DIRECTOR_COMP;
        }
    }

    @Override
    public String toString() {
        return super.toString() + "::" + managementRole + " Compensation " + df.format(addtlCompensation/PAY_PERIODS); // fix addtlCompensation in kiosk?
    }

    @Override
    public boolean equals(Object obj) {
        Management emp = (Management) obj;
        if (!super.equals(obj) && super.getSalary() != emp.getSalary() && super.getPayment() != emp.getPayment() && !managementRole.equals(emp.managementRole)
            && addtlCompensation != emp.addtlCompensation) {
                return false;
        }
        return true;
    }

    @Override
    public void calculatePayment() {
        super.setPayment((super.getSalary() + addtlCompensation)/PAY_PERIODS);
    }
}
