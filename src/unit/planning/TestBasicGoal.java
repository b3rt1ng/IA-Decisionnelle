package unit.planning;

import planningtests.BasicGoalTests;

/**
 * Class containing all functions to tests all functions of the class BasicGoal.
 * 
 * @author Antoine Collenot, Kenzo Lecoindre
 */
public class TestBasicGoal 
{
    /**
     * Launch all the tests concerning this class.
     * 
     * @return true if all tests are ok, false otherwhise.
     */
    public static boolean allTests()
    {
        boolean ok = true;

        ok = ok && BasicGoalTests.testIsSatisfiedBy();

        System.out.println(ok ? " All tests OK " : " At least one test KO " );

        return ok;
    }    
}
