package unit.representation;

import representationtests.DifferenceConstraintTests;
import unit.IsTestable;

/**
 * Class containing all functions to tests all functions of the class DifferenceConstraint.
 * 
 * @author Antoine Collenot, Kenzo Lecoindre
 */
public class TestDifferenceConstraint implements IsTestable
{
    /**
     * Launch all the tests concerning this class.
     * 
     * @return true if all tests are ok, false otherwhise.
     */
    public boolean allTests()
    {
        boolean ok = true ;

        ok = ok && DifferenceConstraintTests.testGetScope();
        ok = ok && DifferenceConstraintTests.testIsSatisfiedBy();

        return ok;
    }   
}
