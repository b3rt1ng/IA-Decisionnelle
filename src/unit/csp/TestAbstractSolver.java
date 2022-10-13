package unit.csp;

import csptests.AbstractSolverTests;

/**
 * Class containing all functions to tests all functions of the class SolverTests.
 * 
 * @author Antoine Collenot, Kenzo Lecoindre
 */

public class TestAbstractSolver 
{
    /**
     * Launch all the tests concerning this class.
     * 
     * @return true if all tests are ok, false otherwhise.
     */
    public static boolean allTests()
    {
        boolean ok = true;

        ok = ok && AbstractSolverTests.testIsConsistent();

        System.out.println(ok ? " All tests OK " : " At least one test KO " );

        return ok;
    } 

}
