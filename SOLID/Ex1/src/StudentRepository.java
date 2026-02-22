/**
 * Responsibility: abstract the persistence mechanism for student records.
 * OnboardingService depends on this interface, not on FakeDb directly.
 */
public interface StudentRepository {
    void save(StudentRecord record);
    int count();
}
