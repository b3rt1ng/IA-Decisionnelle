package unit.csp;

import csptests.MACSolverTests;
import unit.IsTestable;

/**
 * Class containing all functions to tests all functions of the class SolverTests.
 * 
 * @author Antoine Collenot, Kenzo Lecoindre
 */

public class TestMACSolver implements IsTestable
{
    /**
     * Launch all the tests concerning this class.
     * 
     * @return true if all tests are ok, false otherwhise.
     */
    public boolean allTests()
    {
        boolean ok = true;

        ok = ok && MACSolverTests.testSolve();

        return ok;
    } 

}
