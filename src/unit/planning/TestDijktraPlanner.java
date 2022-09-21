package unit.planning;

import planningtests.DijkstraPlannerTests;

public class TestDijktraPlanner
{
    public static boolean allTests()
    {
        boolean ok = true;

        ok = ok && DijkstraPlannerTests.testPlan();

        System.out.println(ok ? " All tests OK " : " At least one test KO " );

        return ok;
    }    
}