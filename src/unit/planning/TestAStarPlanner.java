package unit.planning;

import planningtests.AStarPlannerTests;
import unit.IsTestable;

/**
 * Class containing all functions to tests all functions of the class AStarPlanner.
 * 
 * @author Antoine Collenot, Kenzo Lecoindre
 */
public class TestAStarPlanner implements IsTestable
{
    /**
     * Launch all the tests concerning this class.
     * 
     * @return true if all tests are ok, false otherwhise.
     */
    public boolean allTests()
    {
        boolean ok = true;

        ok = ok && AStarPlannerTests.testPlan();

        System.out.println(ok ? " All tests OK " : " At least one test KO " );

        return ok;
    } 

}
