package unit.planning;

import planningtests.BasicActionTests;
import unit.IsTestable;

/**
 * Class containing all functions to tests all functions of the class BasicAction.
 * 
 * @author Antoine Collenot, Kenzo Lecoindre
 */
public class TestBasicAction implements IsTestable
{
    /**
     * Launch all the tests concerning this class.
     * 
     * @return true if all tests are ok, false otherwhise.
     */
    public boolean allTests()
    {
        boolean ok = true;

        ok = ok && BasicActionTests.testIsApplicable();
        ok = ok && BasicActionTests.testSuccessor();
        ok = ok && BasicActionTests.testGetCost();

        return ok;
    }
}
