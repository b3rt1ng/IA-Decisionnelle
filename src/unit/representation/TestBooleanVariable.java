package unit.representation;

import representationtests.BooleanVariableTests;

public class TestBooleanVariable
{
    public static boolean allTests()
    {
        boolean ok = true ;
        ok = ok && BooleanVariableTests.testConstructor();
        ok = ok && BooleanVariableTests.testEquals();
        ok = ok && BooleanVariableTests.testHashCode();
        return ok;
    }
}