package unit.csp;

import csptests.ArcConsistencyTests;
import unit.IsTestable;

public class TestArcConsistency implements IsTestable
{
    public boolean allTests()
    {
        boolean ok = true;

        ok = ok && ArcConsistencyTests.testEnforceNodeConsistency();
        ok = ok && ArcConsistencyTests.testRevise();
        ok = ok && ArcConsistencyTests.testAC1();

        return ok;
    }
}
