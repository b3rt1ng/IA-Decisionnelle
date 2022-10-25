package unit.representation;

import representationtests.UnaryConstraintTests;
import unit.IsTestable;

/**
 * Class containing all functions to tests all functions of the class UnaryConstraint.
 * 
 * @author Antoine Collenot, Kenzo Lecoindre
 */
public class TestUnaryConstraint implements IsTestable
{
    /**
     * Launch all the tests concerning this class.
     * 
     * @return true if all tests are ok, false otherwhise.
     */
    public boolean allTests()
    {
        boolean ok = true;

        ok = ok && UnaryConstraintTests.testGetScope();
        ok = ok && UnaryConstraintTests.testIsSatisfiedBy();

        return ok;
    }
}
