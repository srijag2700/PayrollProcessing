package Project2;

public class Parttime extends Employee{
    private int hoursWorked;

    public Parttime() {
        hoursWorked = 0;
    }

    @Override
    public String toString() {
        return employeeProfile.toString() + "::Payment " + payment + "::PART TIME::Hourly Rate $"
                + salary + "::Hours worked this period: " + hoursWorked;
    }

    @Override
    public boolean equals(Object obj) {
        Parttime employee = (Parttime) obj;
        if (!employeeProfile.equals(employee.employeeProfile)) {
            return false;
        }
        if (salary != employee.salary && payment != employee.payment && hoursWorked != employee.hoursWorked) {
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
            payment = (maxHours * salary) + (overtimeHours * salary * overtimeRate);
        }
        else {
            payment = hoursWorked * salary;
        }
    }
}
