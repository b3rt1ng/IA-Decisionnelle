package unit.planning;

import planningtests.AStarPlannerTests;

public class TestAStarPlanner {
    
    public static boolean allTests()
    {
        boolean ok = true;

        ok = ok && AStarPlannerTests.testPlan();

        System.out.println(ok ? " All tests OK " : " At least one test KO " );

        return ok;
    } 

}
