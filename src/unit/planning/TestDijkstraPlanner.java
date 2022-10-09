package unit.planning;

import planningtests.DijkstraPlannerTests;

/**
 * Class containing all functions to tests all functions of the class DjikstraPlanner.
 * 
 * @author Kenzo LECOINDRE
 */
public class TestDijkstraPlanner
{
    /**
     * Launch all the tests that this class concern.
     * 
     * @return true if all tests are ok, false otherwhise.
     */
    public static boolean allTests()
    {
        boolean ok = true;

        ok = ok && DijkstraPlannerTests.testPlan();

        System.out.println(ok ? " All tests OK " : " At least one test KO " );

        return ok;
    }    
}