package Project2;
import java.text.DecimalFormat;

public class Parttime extends Employee{

    private int hoursWorked;
    DecimalFormat df = new DecimalFormat("$#,###,###,##0.00");

    public Parttime(Profile employeeProfile, double salary) {
        super(employeeProfile, salary);
        hoursWorked = 0;
    }

    public Parttime(Profile employeeProfile, int hoursWorked) {
        super(employeeProfile);
        this.hoursWorked = hoursWorked;
    }

    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public int getHoursWorked() {
        return hoursWorked;
    }

    @Override
    public String toString() {
        return super.toString() + "::Payment " + df.format(super.getPayment()) + "::PART TIME::Hourly Rate "
                + df.format(super.getSalary()) + "::Hours worked this period: " + hoursWorked;
    }

    @Override
    public boolean equals(Object obj) {
        Parttime emp = (Parttime) obj;
        if (!super.equals(obj) && super.getSalary() != emp.getSalary() && super.getPayment() != emp.getPayment() && hoursWorked != emp.getHoursWorked()) {
            return false;
        }
        return true;
    }

    @Override
    public void calculatePayment() {
        int overtimeHours = 0;
        int maxHours = 80;
        if (hoursWorked > maxHours) {
            overtimeHours = hoursWorked - maxHours;
            double overtimeRate = 1.5;
            super.setPayment((maxHours * super.getSalary()) + (overtimeHours * super.getSalary() * overtimeRate));
        }
        else {
            super.setPayment(hoursWorked * super.getSalary());
        }
    }
}
