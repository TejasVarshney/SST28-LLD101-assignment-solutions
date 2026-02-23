import java.util.*;

public class Credits implements EligibilityRule {
    private final int mini;
    public Credits(int mini)
    {
        this.mini = mini;
    }
    @Override
    public void evaluate(StudentProfile s, List<String> reasons) {
        if(s.earnedCredits < mini) reasons.add("credits below " + mini);
    }
}
