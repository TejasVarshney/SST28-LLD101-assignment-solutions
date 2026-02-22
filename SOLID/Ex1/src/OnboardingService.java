import java.util.List;

/**
 * Responsibility: orchestrate the student registration workflow.
 * Delegates parsing, validation, persistence, and printing to collaborators.
 * Has no knowledge of FakeDb, console IO, or rule details.
 */
public class OnboardingService {

    private final StudentInputParser  parser;
    private final StudentValidator    validator;
    private final StudentRepository   repo;
    private final RegistrationPrinter printer;

    public OnboardingService(
            StudentInputParser   parser,
            StudentValidator     validator,
            StudentRepository    repo,
            RegistrationPrinter  printer) {
        this.parser    = parser;
        this.validator = validator;
        this.repo      = repo;
        this.printer   = printer;
    }

    public void registerFromRawInput(String raw) {
        printer.printInput(raw);

        ParsedInput      parsed = parser.parse(raw);
        List<String>     errors = validator.validate(parsed);

        if (!errors.isEmpty()) {
            printer.printErrors(errors);
            return;
        }

        String id = IdUtil.nextStudentId(repo.count());
        StudentRecord rec = new StudentRecord(
                id, parsed.name, parsed.email, parsed.phone, parsed.program);

        repo.save(rec);
        printer.printSuccess(id, rec, repo.count());
    }
}
