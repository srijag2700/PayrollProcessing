package Project2;
import java.util.Scanner;

/**
 * insert comments here
 */

public class PayrollProcessing {
    Company com = new Company();
    Scanner sc = new Scanner(System.in);
    String input = "";

    private final static int MAX_HOURS = 100;

    /**
     * Main method for the payroll processor. which runs the instance.
     */
    public void run() {
        System.out.println(("Payroll Processing starts."));
        do {
            input = sc.nextLine();
            if (input.equals("Q")) {
                System.out.println("Payroll Processing completed.");
                return;
            }

            //tokenize input
            String[] tokens = input.split(" ");
            String command = tokens[0];

            if (command.charAt(0) == 'A') {
                // adding new employees
                String empName = tokens[1];
                String deptName = tokens[2];
                Date dateHired = new Date(tokens[3]);
                double payInfo = Double.parseDouble(tokens[4]);
                boolean added = false;

                if (!dateHired.isValid()) {
                    System.out.println(dateHired + " is not a valid date!");
                }
                else {
                    Profile newEmpProf = new Profile(empName, deptName, dateHired);
                    if (command.charAt(1) == 'P') {
                        Parttime newPartTime = new Parttime(newEmpProf, payInfo);
                        added = com.add(newPartTime);
                    }
                    else if (command.charAt(1) == 'F') {
                        Fulltime newFullTime = new Fulltime(newEmpProf, payInfo);
                        added = com.add(newFullTime);
                    }
                    else if (command.charAt(2) == 'M') {
                        int mgmtStatus = Integer.parseInt(tokens[5]); // 1, 2, or 3 depending on type of management!
                        Management newMgmt = new Management(newEmpProf, payInfo, mgmtStatus);
                        added = com.add(newMgmt);
                    }
                }

                if (added) {
                    System.out.println("Employee added.");
                }
                else {
                    System.out.println("Employee is already in the list.");
                }
            }

            else if (command.equals("R")) {
                //do remove
                String empName = tokens[1];
                String deptName = tokens[2];
                Date dateHired = new Date(tokens[3]);
                Profile tempProfile = new Profile(empName, deptName, dateHired);
                Employee tempEmployee = new Employee(tempProfile);
                try {
                    if (com.remove(tempEmployee)) {
                        System.out.println("Employee removed.");
                    }
                    else {
                        System.out.println("Employee doesn't exist.");
                    }
                }
                catch (NullPointerException e) {
                    System.out.println("Employee database is empty.");
                }
            }

            else if (command.equals("C")) {
                //calculate payments
                try {
                    com.processPayments();
                }
                catch (NullPointerException e) {
                    System.out.println("Employee database is empty.");
                }
            }

            else if (command.equals("S")) {
                //set hours for a part time employee
                String empName = tokens[1];
                String deptName = tokens[2];
                Date dateHired = new Date(tokens[3]);
                int hoursWorked = 0;

                try {
                    hoursWorked = Integer.parseInt(tokens[4]);
                }
                catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Invalid input.");
                }

                if (hoursWorked > MAX_HOURS) {
                    System.out.println("Invalid Hours: over 100");
                }
                else if (hoursWorked < 0) {
                    System.out.println("Invalid Hours: less than 0");
                }
                else {
                    Profile tempProfile = new Profile(empName, deptName, dateHired);
                    Parttime tempPartTime = new Parttime(tempProfile, hoursWorked);

                    if (com.setHours(tempPartTime)) {
                        System.out.println("Working hours set.");
                    }
                    else {
                        System.out.println("Employee doesn't exist.");
                    }
                }
            }

            else if (command.equals("PA")) {
                //do print all
                com.print();
            }

            else if (command.equals("PD")) {
                //do print by dates
                com.printByDepartment();
            }

            else if (command.equals("PH")) {
                //do print by numbers
                com.printByDate();
            }

            else {
                //invalid
                System.out.println("Command '" + command + "' is not supported!");
            }
        }
        while (!input.equals("Q"));
        System.out.println("Payroll Processing completed.");
        return;
    }
}