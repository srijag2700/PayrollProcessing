package Project2;

public class Management extends Fulltime{
    private String managementRole;
    private int addtlCompensation;

    public Management(Profile employeeProfile, double salary) {
        super(employeeProfile, salary);
        managementRole = "";
        addtlCompensation = 0;
    }

    @Override
    public String toString() {
        return super.toString() + "::Payment " + super.getPayment() + "::FULL TIME::Annual Salary "
                + super.getSalary() + "::" + managementRole + " $" + addtlCompensation; // fix addtlCompensation in kiosk?
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
