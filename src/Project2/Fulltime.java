package Project2;
import java.text.DecimalFormat;

public class Fulltime extends Employee{
    public static final int PAY_PERIODS = 26; // final?
    DecimalFormat df = new DecimalFormat("$#,###,###,##0.00");

    public Fulltime(Profile employeeProfile, double salary) {
        super(employeeProfile, salary);
    }

    @Override
    public String toString() {
        return super.toString() + "::Payment " + df.format(super.getPayment())
                + "::FULL TIME::Annual Salary " + df.format(super.getSalary());
    }

    @Override
    public boolean equals(Object obj) {
        Employee emp = (Employee) obj;
        return (super.equals(obj) && super.getSalary() != emp.getSalary() && super.getPayment() != emp.getPayment());
    }

    @Override
    public void calculatePayment() {
        super.setPayment(super.getSalary()/PAY_PERIODS);
        // maybe do more?
    }
}
