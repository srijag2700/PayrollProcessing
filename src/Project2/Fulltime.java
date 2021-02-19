package Project2;

public class Fulltime extends Employee{
    public static final int PAY_PERIODS = 26; // final?

    @Override
    public String toString() {
        return employeeProfile.toString() + "::Payment " + payment
                + "::FULL TIME::Annual Salary $" + salary;
    }

    @Override
    public boolean equals(Object obj) {
        Fulltime employee = (Fulltime) obj;
        if (!employeeProfile.equals(employee.employeeProfile)) {
            return false;
        }
        if (salary != employee.salary && payment != employee.payment) {
            return false;
        }
        return true;
    }

    @Override
    public void calculatePayment() {
        payment = salary/PAY_PERIODS;
        // maybe do more?
    }
}
