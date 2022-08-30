package unit.representation;

import representationtests.VariableTests;

public class TestVariable
{
    public TestVariable()
    {
        boolean ok = true ;
        ok = ok && VariableTests.testEquals();
        ok = ok && VariableTests.testHashCode();
        System.out.println(ok ? " All tests OK " : " At least one test KO ");
    }

    public static void main(String[] args) {
        boolean ok = true ;
        ok = ok && VariableTests.testEquals();
        ok = ok && VariableTests.testHashCode();
        System.out.println(ok ? " All tests OK " : " At least one test KO ");
    }
}