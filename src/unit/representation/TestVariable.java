package unit.representation;

import representationtests.VariableTests;

/**
 * Class containing all functions to tests all functions of the class Variable.
 * 
 * @author Kenzo LECOINDRE
 */
public class TestVariable
{
    /**
     * Launch all the tests concerning this class.
     * 
     * @return true if all tests are ok, false otherwhise.
     */
    public static boolean allTests()
    {
        boolean ok = true ;

        ok = ok && VariableTests.testEquals();
        ok = ok && VariableTests.testHashCode();

        System.out.println(ok ? " All tests OK " : " At least one test KO " );

        return ok;
    }
}