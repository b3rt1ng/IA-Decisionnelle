package unit.planning;

import planningtests.DFSPlannerTests;

public class TestDFSPlanner 
{
    public static boolean allTests()
    {
        boolean ok = true;

        ok = ok && DFSPlannerTests.testPlan();

        return ok;
    }
}
