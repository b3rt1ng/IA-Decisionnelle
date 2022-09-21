package unit.planning;

import planningtests.BasicGoalTests;

public class TestBasicGoal 
{
    public static boolean allTests()
    {
        boolean ok = true;

        ok = ok && BasicGoalTests.testIsSatisfiedBy();

        System.out.println(ok ? " All tests OK " : " At least one test KO " );

        return ok;
    }    
}
