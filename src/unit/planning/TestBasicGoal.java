package unit.planning;

import planningtests.BasicGoalTests;

public class TestBasicGoal 
{
    public static boolean allTests()
    {
        boolean ok = true;

        ok = ok && BasicGoalTests.testIsSatisfiedBy();

        return ok;
    }    
}
