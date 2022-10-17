package unit.planning;

import planningtests.DFSPlannerTests;
import unit.IsTestable;

/**
 * Class containing all functions to tests all functions of the class DFSPlanner.
 * 
 * @author Antoine Collenot, Kenzo Lecoindre
 */
public class TestDFSPlanner implements IsTestable
{
    /**
     * Launch all the tests that this class concern.
     * 
     * @return true if all tests are ok, false otherwhise.
     */
    public boolean allTests()
    {
        boolean ok = true;

        ok = ok && DFSPlannerTests.testPlan();

        System.out.println(ok ? " All tests OK " : " At least one test KO " );

        return ok;
    }
}
