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
        System.out.println("");
        TestBooleanVariable testBooleanVariable = new TestBooleanVariable();
        ok = ok && testBooleanVariable.allTests();
        System.out.println("");

        //Test Contraintes
        TestDifferenceConstraint testDifferenceConstraint = new TestDifferenceConstraint();
        ok = ok && testDifferenceConstraint.allTests();
        System.out.println("");
        TestImplication testImplication = new TestImplication();
        ok = ok && testImplication.allTests();
        System.out.println("");
        TestUnaryConstraint testUnaryConstraint = new TestUnaryConstraint();
        ok = ok && testUnaryConstraint.allTests();
        System.out.println("");
        
        return ok;
    }
}
