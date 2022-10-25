package unit.planning;

import planningtests.BasicGoalTests;
import unit.IsTestable;

/**
 * Class containing all functions to tests all functions of the class BasicGoal.
 * 
 * @author Antoine Collenot, Kenzo Lecoindre
 */
public class TestBasicGoal implements IsTestable
{
    /**
     * Launch all the tests concerning this class.
     * 
     * @return true if all tests are ok, false otherwhise.
     */
    public boolean allTests()
    {
        boolean ok = true;

        ok = ok && BasicGoalTests.testIsSatisfiedBy();

        return ok;
    }    
}
