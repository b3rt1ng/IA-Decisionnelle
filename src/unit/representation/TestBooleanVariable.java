package unit.representation;

import representationtests.BooleanVariableTests;
import unit.IsTestable;

/**
 * Class containing all functions to tests all functions of the class BooleanVariable.
 * 
 * @author Antoine Collenot, Kenzo Lecoindre
 */
public class TestBooleanVariable implements IsTestable
{
    /**
     * Launch all the tests concerning this class.
     * 
     * @return true if all tests are ok, false otherwhise.
     */
    public boolean allTests()
    {
        boolean ok = true ;

        ok = ok && BooleanVariableTests.testConstructor();
        ok = ok && BooleanVariableTests.testEquals();
        ok = ok && BooleanVariableTests.testHashCode();

        return ok;
    }
}