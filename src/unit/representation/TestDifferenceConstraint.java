package unit.representation;

import representationtests.DifferenceConstraintTests;

public class TestDifferenceConstraint 
{
    public static boolean allTests()
    {
        boolean ok = true ;

        ok = ok && DifferenceConstraintTests.testGetScope();
        ok = ok && DifferenceConstraintTests.testIsSatisfiedBy();

        System.out.println(ok ? " All tests OK " : " At least one test KO " );

        return ok;
    }   
}
