package Project2;

public class Management extends Fulltime{
    private String managementRole;
    private int addtlCompensation;

    public Management() {
        managementRole = "";
        addtlCompensation = 0;
    }

    @Override
    public String toString() {
        return employeeProfile.toString() + "::Payment " + payment + "::FULL TIME::Annual Salary "
                + salary + "::" + managementRole + " $" + addtlCompensation; // fix addtlCompensation in kiosk?
    }

    @Override
    public boolean equals(Object obj) {
        Management employee = (Management) obj;
        if (!employeeProfile.equals(employee.employeeProfile)) {
            return false;
        }
        if (salary != employee.salary && payment != employee.payment && !managementRole.equals(employee.managementRole)
            && addtlCompensation != employee.addtlCompensation) {
                return false;
        }
        return true;
    }

    @Override
    public void calculatePayment() {
        payment = (salary + addtlCompensation)/PAY_PERIODS;
    }
}
