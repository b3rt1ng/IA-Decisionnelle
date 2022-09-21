package unit.representation;

import representationtests.ImplicationTests;

public class TestImplication 
{
    public static boolean allTests()
    {
        boolean ok = true;

        ok = ok && ImplicationTests.testGetScope();
        ok = ok && ImplicationTests.testIsSatisfiedBy();

        System.out.println(ok ? " All tests OK " : " At least one test KO " );

        return ok;
    }    
}
