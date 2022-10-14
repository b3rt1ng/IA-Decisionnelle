package unit.csp;

import csptests.ArcConsistencyTests;

public class TestArcConsistency 
{
    public static boolean allTests()
    {
        boolean ok = true;

        ok = ok && ArcConsistencyTests.testEnforceNodeConsistency();
        ok = ok && ArcConsistencyTests.testRevise();
        ok = ok && ArcConsistencyTests.testAC1();

        return ok;
    }
}
