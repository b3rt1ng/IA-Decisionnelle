package unit.planning;

import planningtests.BasicActionTests ;

/**
 * Class containing all functions to tests all functions of the class BasicAction.
 * 
 * @author Kenzo LECOINDRE
 */
public class TestBasicAction 
{
    /**
     * Launch all the tests that this class concern.
     * 
     * @return true if all tests are ok, false otherwhise.
     */
    public static boolean allTests()
    {
        boolean ok = true;

        ok = ok && BasicActionTests.testIsApplicable();
        ok = ok && BasicActionTests.testSuccessor();
        ok = ok && BasicActionTests.testGetCost();

        System.out.println(ok ? " All tests OK " : " At least one test KO " );

        return ok;
    }
}
