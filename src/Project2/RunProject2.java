package Project2;

/**
 * This is the main driver class for Project 2.
 * It instantiates a PayrollProcessing object, which can access the Company and Employees.
 * @author Srija Gottiparthi, Catherine Nguyen
 */
public class RunProject2 {
    /**
     * Main method that instantiantes and runs a new PayrollProcessing object.
     * @param args the given arguments
     */
    public static void main(String[] args) {
        new PayrollProcessing().run();
    }
}