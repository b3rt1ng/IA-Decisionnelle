package unit.representation;

import representationtests.DifferenceConstraintTests;

/**
 * Class containing all functions to tests all functions of the class DifferenceConstraint.
 * 
 * @author Kenzo LECOINDRE
 */
public class TestDifferenceConstraint 
{
    /**
     * Launch all the tests that this class concern.
     * 
     * @return true if all tests are ok, false otherwhise.
     */
    public static boolean allTests()
    {
        boolean ok = true ;

        ok = ok && DifferenceConstraintTests.testGetScope();
        ok = ok && DifferenceConstraintTests.testIsSatisfiedBy();

        System.out.println(ok ? " All tests OK " : " At least one test KO " );

        return ok;
    }   
}
