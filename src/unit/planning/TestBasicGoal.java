package unit.planning;

import planningtests.BasicGoalTests;

/**
 * Class containing all functions to tests all functions of the class BasicGoal.
 * 
 * @author Kenzo LECOINDRE
 */
public class TestBasicGoal 
{
    /**
     * Launch all the tests that this class concern.
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
