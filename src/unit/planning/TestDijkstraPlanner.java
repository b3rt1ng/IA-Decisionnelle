package unit.planning;

import planningtests.DijkstraPlannerTests;
import unit.IsTestable;

/**
 * Class containing all functions to tests all functions of the class DjikstraPlanner.
 * 
 * @author Antoine Collenot, Kenzo Lecoindre
 */
public class TestDijkstraPlanner implements IsTestable
{
    /**
     * Launch all the tests concerning this class.
     * 
     * @return true if all tests are ok, false otherwhise.
     */
    public boolean allTests()
    {
        boolean ok = true;

        ok = ok && DijkstraPlannerTests.testPlan();

        System.out.println(ok ? " All tests OK " : " At least one test KO " );

        return ok;
    }    
}