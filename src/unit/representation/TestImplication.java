package unit.representation;

import representationtests.ImplicationTests;

public class TestImplication 
{
    public static boolean allTests()
    {
        boolean ok = true;
        ok = ok && ImplicationTests.testGetScope();
        ok = ok && ImplicationTests.testIsSatisfiedBy();
        return ok;
    }    
}
