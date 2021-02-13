package Project2;

public class Fulltime extends Employee{
    int payPeriods = 26; // final?

    @Override
    public String toString() {
        return employeeProfile.toString() + "::Payment " + payment
                + "::FULL TIME::Annual Salary " + salary;
    }

    @Override
    public boolean equals(Fulltime employee) { // ?
        // ?
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
        payment = salary/payPeriods;
        // maybe do more?
    }
}
