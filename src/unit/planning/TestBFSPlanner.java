package unit.planning;

import planningtests.BFSPlannerTests;
import unit.IsTestable;

/**
 * Class containing all functions to tests all functions of the class BFSPlanner.
 * 
 * @author Antoine Collenot, Kenzo Lecoindre
 */
public class TestBFSPlanner implements IsTestable
{
    /**
     * Launch all the tests concerning this class.
     * 
     * @return true if all tests are ok, false otherwhise.
     */
    public boolean allTests()
    {
        boolean ok = true;

        ok = ok && BFSPlannerTests.testPlan();

        System.out.println(ok ? " All tests OK " : " At least one test KO " );

        return ok;
    }
}
