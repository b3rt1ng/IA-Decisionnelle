package unit.representation;

import representationtests.BooleanVariableTests;

/**
 * Class containing all functions to tests all functions of the class BooleanVariable.
 * 
 * @author Kenzo LECOINDRE
 */
public class TestBooleanVariable
{
    /**
     * Launch all the tests concerning this class.
     * 
     * @return true if all tests are ok, false otherwhise.
     */
    public static boolean allTests()
    {
        boolean ok = true ;

        ok = ok && BooleanVariableTests.testConstructor();
        ok = ok && BooleanVariableTests.testEquals();
        ok = ok && BooleanVariableTests.testHashCode();

        System.out.println(ok ? " All tests OK " : " At least one test KO " );

        return ok;
    }
}