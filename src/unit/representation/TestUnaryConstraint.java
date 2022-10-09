package unit.representation;

import representationtests.UnaryConstraintTests;

/**
 * Class containing all functions to tests all functions of the class UnaryConstraint.
 * 
 * @author Kenzo LECOINDRE
 */
public class TestUnaryConstraint 
{
    /**
     * Launch all the tests that this class concern.
     * 
     * @return true if all tests are ok, false otherwhise.
     */
    public static boolean allTests()
    {
        boolean ok = true;

        ok = ok && UnaryConstraintTests.testGetScope();
        ok = ok && UnaryConstraintTests.testIsSatisfiedBy();

        System.out.println(ok ? " All tests OK " : " At least one test KO " );

        return ok;
    }
}
