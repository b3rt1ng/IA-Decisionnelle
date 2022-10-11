package unit.csp;

import csptests.BacktrackSolverTests;

/**
 * Class containing all functions to tests all functions of the class SolverTests.
 * 
 * @author Antoine Collenot, Kenzo Lecoindre
 */

public class TestBacktrackSolver 
{
    /**
     * Launch all the tests concerning this class.
     * 
     * @return true if all tests are ok, false otherwhise.
     */
    public static boolean allTests()
    {
        boolean ok = true;

        ok = ok && BacktrackSolverTests.testSolve();

        System.out.println(ok ? " All tests OK " : " At least one test KO " );

        return ok;
    } 

}
