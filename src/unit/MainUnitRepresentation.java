package unit;

import unit.representation.*;

/**
 * @author Kenzo Lecoindre
 * 
 * Contains all the tests concerning the "representation" package.
 */
public class MainUnitRepresentation implements IsTestable
{
    @Override
    public boolean allTests()
    {
        boolean ok = true;
        
        //Test Variables
        TestVariable testVariable = new TestVariable();
        ok = ok && testVariable.allTests();
        System.err.println("");
        TestBooleanVariable testBooleanVariable = new TestBooleanVariable();
        ok = ok && testBooleanVariable.allTests();
        System.err.println("");

        //Test Contraintes
        TestDifferenceConstraint testDifferenceConstraint = new TestDifferenceConstraint();
        ok = ok && testDifferenceConstraint.allTests();
        System.err.println("");
        TestImplication testImplication = new TestImplication();
        ok = ok && testImplication.allTests();
        System.err.println("");
        TestUnaryConstraint testUnaryConstraint = new TestUnaryConstraint();
        ok = ok && testUnaryConstraint.allTests();
        System.err.println("");

        System.err.println(ok ? " All tests of the package 'representation' are OK " : " At least one test of the package 'representation' is KO " );
        System.err.println("");
        System.err.println("");
        
        return ok;
    }
}
