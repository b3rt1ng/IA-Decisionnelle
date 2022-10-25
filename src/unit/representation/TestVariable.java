package unit.representation;

import representationtests.VariableTests;
import unit.IsTestable;

/**
 * Class containing all functions to tests all functions of the class Variable.
 * 
 * @author Antoine Collenot, Kenzo Lecoindre
 */
public class TestVariable implements IsTestable
{
    /**
     * Launch all the tests concerning this class.
     * 
     * @return true if all tests are ok, false otherwhise.
     */
    public boolean allTests()
    {
        boolean ok = true ;

        ok = ok && VariableTests.testEquals();
        ok = ok && VariableTests.testHashCode();

        return ok;
    }
}