/**
 * Immutable value object holding the fields extracted from a raw input string.
 * Responsibility: carry parsed data — nothing more.
 */
public class ParsedInput {
    public final String name;
    public final String email;
    public final String phone;
    public final String program;

    public ParsedInput(String name, String email, String phone, String program) {
        this.name    = name;
        this.email   = email;
        this.phone   = phone;
        this.program = program;
    }
}
