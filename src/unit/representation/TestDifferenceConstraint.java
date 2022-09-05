package unit.representation;

import representationtests.DifferenceConstraintTests;

public class TestDifferenceConstraint 
{
    public static boolean allTests()
    {
        boolean ok = true ;
        ok = ok && DifferenceConstraintTests.testGetScope();
        ok = ok && DifferenceConstraintTests.testIsSatisfiedBy();
        return ok;
    }   
}
