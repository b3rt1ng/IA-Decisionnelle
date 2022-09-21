package unit.planning;

import planningtests.DFSPlannerTests;

public class TestDFSPlanner 
{
    public static boolean allTests()
    {
        boolean ok = true;

        ok = ok && DFSPlannerTests.testPlan();

        System.out.println(ok ? " All tests OK " : " At least one test KO " );

        return ok;
    }
}
