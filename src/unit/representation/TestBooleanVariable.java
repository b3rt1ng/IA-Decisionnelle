package unit.representation;

import representationtests.BooleanVariableTests;

public class TestBooleanVariable
{
    public TestBooleanVariable()
    {
        boolean ok = true ;
        ok = ok && BooleanVariableTests.testConstructor();
        ok = ok && BooleanVariableTests.testEquals();
        ok = ok && BooleanVariableTests.testHashCode();
        System.out.println(ok ? " All tests OK " : " At least one test KO ");
    }
}