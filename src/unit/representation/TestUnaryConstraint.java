package unit.representation;

import representationtests.UnaryConstraintTests;

public class TestUnaryConstraint 
{
    public static boolean allTests()
    {
        boolean ok = true;

        ok = ok && UnaryConstraintTests.testGetScope();
        ok = ok && UnaryConstraintTests.testIsSatisfiedBy();

        System.out.println(ok ? " All tests OK " : " At least one test KO " );

        return ok;
    }
}
