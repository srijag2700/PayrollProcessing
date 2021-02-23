package Project2;
import java.util.Scanner;

/**
 * The PayrollProcessing class acts as a front-end for users to access the Company and interact with Employees.
 *
 * Users can utilize all Company commands, including adding, removing, setting part-time employee hours, performing wage calculations,
 * and viewing the list of employees in the library sorted by their department, date hired, or in their current order.
 * @author Srija Gottiparthi, Catherine Nguyen
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
                    continue;
                }
                else if (!deptName.equals("CS") && !deptName.equals("ECE") && !deptName.equals("IT")) {
                    System.out.println("'" + deptName + "' is not a valid department code.");
                    continue;
                }
                else {
                    Profile newEmpProf = new Profile(empName, deptName, dateHired);
                    if (command.charAt(1) == 'P') {
                        if (payInfo < 0) {
                            System.out.println("Pay rate cannot be negative.");
                            continue;
                        }
                        Parttime newPartTime = new Parttime(newEmpProf, payInfo);
                        added = com.add(newPartTime);
                    }
                    else if (command.charAt(1) == 'F') {
                        if (payInfo < 0) {
                            System.out.println("Salary cannot be negative.");
                            continue;
                        }
                        Fulltime newFullTime = new Fulltime(newEmpProf, payInfo);
                        added = com.add(newFullTime);
                    }
                    else if (command.charAt(1) == 'M') {
                        int mgmtStatus = Integer.parseInt(tokens[5]); // 1, 2, or 3 depending on type of management!
                        if (mgmtStatus <= 0  || mgmtStatus > 3) {
                            System.out.println("Invalid management code.");
                            continue;
                        }
                        else if (payInfo < 0) {
                            System.out.println("Salary cannot be negative.");
                            continue;
                        }
                        else {
                            Management newMgmt = new Management(newEmpProf, payInfo, mgmtStatus);
                            added = com.add(newMgmt);
                        }
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
                if (com.isEmpty()) {
                    System.out.println("Employee database is empty.");
                    continue;
                }

                String empName = tokens[1];
                String deptName = tokens[2];
                Date dateHired = new Date(tokens[3]);
                Profile tempProfile = new Profile(empName, deptName, dateHired);
                Employee tempEmployee = new Employee(tempProfile);
                if (com.remove(tempEmployee)) {
                    System.out.println("Employee removed.");
                }
                else {
                    System.out.println("Employee doesn't exist.");
                }
            }

            else if (command.equals("C")) {
                //calculate payments

                if (com.isEmpty()) {
                    System.out.println("Employee database is empty.");
                    continue;
                }

                com.processPayments();
                System.out.println("Calculation of employee payments is done.");
            }

            else if (command.equals("S")) {
                //set hours for a part time employee

                if (com.isEmpty()) {
                    System.out.println("Employee database is empty.");
                }
                else {
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
                        System.out.println("Working hours cannot be negative.");
                    }
                    else {
                        Profile tempProfile = new Profile(empName, deptName, dateHired);
                        Parttime tempPartTime = new Parttime(tempProfile, hoursWorked);

                        if (com.setHours(tempPartTime)) {
                            System.out.println("Working hours set.");
                        }
                        else {
                            System.out.println("Employee does not exist.");
                        }
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