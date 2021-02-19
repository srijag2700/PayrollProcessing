package Project2;

public class Fulltime extends Employee{
    public static final int PAY_PERIODS = 26; // final?

    public Fulltime(Profile employeeProfile, double salary) {
        super(employeeProfile, salary);
    }

    @Override
    public String toString() {
        return super.toString() + "::Payment " + super.getPayment()
                + "::FULL TIME::Annual Salary $" + super.getSalary();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public void calculatePayment() {
        super.setPayment(super.getSalary()/PAY_PERIODS);
        // maybe do more?
    }
}
