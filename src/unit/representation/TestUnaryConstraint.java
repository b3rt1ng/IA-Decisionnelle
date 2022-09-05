package unit.representation;

import representationtests.UnaryConstraintTests;

public class TestUnaryConstraint 
{
    public static boolean allTests()
    {
        boolean ok = true;
        ok = ok && UnaryConstraintTests.testGetScope();
        ok = ok && UnaryConstraintTests.testIsSatisfiedBy();
        return ok;
    }
}
