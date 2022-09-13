package unit.planning;

import planningtests.BFSPlannerTests;

public class TestBFSPlanner 
{
    public static boolean allTests()
    {
        boolean ok = true;

        ok = ok && BFSPlannerTests.testPlan();

        return ok;
    }
}
