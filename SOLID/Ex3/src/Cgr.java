import java.util.*;

public class Cgr implements EligibilityRule  {
    private final double mini;
    public Cgr(double mini)
    {
        this.mini = mini;
    }
    @Override
    public void evaluate(StudentProfile s, List<String> reasons) {
        if(s.cgr < mini) reasons.add("CGR below " + mini);
    }
}
