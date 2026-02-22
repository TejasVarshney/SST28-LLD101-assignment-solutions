import java.util.List;

/**
 * Responsibility: handle all console output for the registration workflow.
 * Business logic and persistence are not its concern.
 */
public class RegistrationPrinter {

    public void printInput(String raw) {
        System.out.println("INPUT: " + raw);
    }

    public void printErrors(List<String> errors) {
        System.out.println("ERROR: cannot register");
        for (String error : errors) {
            System.out.println("- " + error);
        }
    }

    public void printSuccess(String id, StudentRecord record, int totalCount) {
        System.out.println("OK: created student " + id);
        System.out.println("Saved. Total students: " + totalCount);
        System.out.println("CONFIRMATION:");
        System.out.println(record);
    }
}
