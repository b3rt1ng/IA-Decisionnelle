package unit.planning;

import planningtests.BasicActionTests ;

public class TestBasicAction 
{
    public static boolean allTests()
    {
        boolean ok = true;

        ok = ok && BasicActionTests.testIsApplicable();
        ok = ok && BasicActionTests.testSuccessor();
        ok = ok && BasicActionTests.testGetCost();

        System.out.println(ok ? " All tests OK " : " At least one test KO " );

        return ok;
    }
}
