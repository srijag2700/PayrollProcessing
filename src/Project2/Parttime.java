package Project2;

public class Parttime extends Employee{

    private int hoursWorked;

    public Parttime(Profile employeeProfile, double salary) {
        super(employeeProfile, salary);
        hoursWorked = 0;
    }

    public int getHoursWorked() {
        return hoursWorked;
    }

    @Override
    public String toString() {
        return super.toString() + "::Payment " + super.getPayment() + "::PART TIME::Hourly Rate $"
                + super.getSalary() + "::Hours worked this period: " + hoursWorked;
    }

    @Override
    public boolean equals(Object obj) {
        Parttime emp = (Parttime) obj;
        if (!super.equals(obj) && hoursWorked != emp.getHoursWorked()) {
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
