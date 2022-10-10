package unit.planning;

import planningtests.AStarPlannerTests;

/**
 * Class containing all functions to tests all functions of the class AStarPlanner.
 * 
 * @author Antoine Collenot
 */
public class TestAStarPlanner 
{
    /**
     * Launch all the tests concerning this class.
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
