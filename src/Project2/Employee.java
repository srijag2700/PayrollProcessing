package Project2;

public class Employee {

    private Profile employeeProfile;
    private double salary; // comment

    private double payment;

    public Employee() {
        this.payment = 0;
    }

    public Employee(Profile employeeProfile, double salary) {
        this.employeeProfile = employeeProfile;
        this.salary = salary;
        this.payment = 0;
    }

    public Profile getEmployeeProfile() {
        return employeeProfile;
    }

    public double getSalary() {
        return salary;
    }

    public void setPayment(double payment) {
        this.payment = payment;
    }

    public double getPayment() {
        return payment;
    }

    public void calculatePayment() {
        return;
    }

    @Override
    public boolean equals(Object obj) {
        Employee emp = (Employee) obj;
        if (!employeeProfile.equals(emp.getEmployeeProfile())) {
            return false;
        }

        return true;
    }
}
