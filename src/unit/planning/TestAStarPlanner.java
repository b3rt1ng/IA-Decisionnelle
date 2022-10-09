package unit.planning;

import planningtests.AStarPlannerTests;

/**
 * Class containing all functions to tests all functions of the class AStarPlanner.
 * 
 * @author Kenzo LECOINDRE
 */
public class TestAStarPlanner 
{
    /**
     * Launch all the tests that this class concern.
     * 
     * @return true if all tests are ok, false otherwhise.
     */
    public static boolean allTests()
    {
        boolean ok = true;

        ok = ok && AStarPlannerTests.testPlan();

        System.out.println(ok ? " All tests OK " : " At least one test KO " );

        return ok;
    } 

}
