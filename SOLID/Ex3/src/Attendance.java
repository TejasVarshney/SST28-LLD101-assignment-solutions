import java.util.*;

public class Attendance implements EligibilityRule {
    private final int mini;
    public Attendance(int mini)
    {
        this.mini = mini;
    }
    @Override
    public void evaluate(StudentProfile s, List<String> reasons) {
        if(s.attendancePct < mini) reasons.add("attendance below " + mini);
    }
}
