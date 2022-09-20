package unit.planning;

import planningtests.DijkstraPlannerTests;

public class TestDijktraPlanner
{
    public static boolean allTests()
    {
        boolean ok = true;

        ok = ok && DijkstraPlannerTests.testPlan();

        return ok;
    }    
}