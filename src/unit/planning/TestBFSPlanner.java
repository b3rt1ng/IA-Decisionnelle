package unit.planning;

import planningtests.BFSPlannerTests;

public class TestBFSPlanner 
{
    public static boolean allTests()
    {
        boolean ok = true;

        ok = ok && BFSPlannerTests.testPlan();

        System.out.println(ok ? " All tests OK " : " At least one test KO " );

        return ok;
    }
}
