import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Responsibility: validate a ParsedInput and return a list of error messages.
 * No IO, no persistence — purely rule-checking logic, making it unit-testable.
 */
public class StudentValidator {

    private final List<String> allowedPrograms;

    /** Default constructor uses the fixed set of allowed programs. */
    public StudentValidator() {
        this(Arrays.asList("CSE", "AI", "SWE"));
    }

    /** Constructor accepting a configurable program list (stretch goal). */
    public StudentValidator(List<String> allowedPrograms) {
        this.allowedPrograms = new ArrayList<>(allowedPrograms);
    }

    /**
     * Returns an empty list when the input is valid;
     * otherwise returns one message per failing rule (order preserved).
     */
    public List<String> validate(ParsedInput input) {
        List<String> errors = new ArrayList<>();
        if (input.name.isBlank()) {
            errors.add("name is required");
        }
        if (input.email.isBlank() || !input.email.contains("@")) {
            errors.add("email is invalid");
        }
        if (input.phone.isBlank() || !input.phone.chars().allMatch(Character::isDigit)) {
            errors.add("phone is invalid");
        }
        if (!allowedPrograms.contains(input.program)) {
            errors.add("program is invalid");
        }
        return errors;
    }
}
