package unit.representation;

import representationtests.VariableTests;

public class TestVariable
{
    public static boolean allTests()
    {
        boolean ok = true ;
        ok = ok && VariableTests.testEquals();
        ok = ok && VariableTests.testHashCode();
        return ok;
    }

    public static void main(String[] args) {
        System.out.println(TestVariable.allTests() ? " All tests OK " : " At least one test KO " );
    }
}