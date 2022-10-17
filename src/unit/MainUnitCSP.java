package unit;

import unit.csp.*;

/**
 * @author Kenzo Lecoindre
 * 
 * Contains all the tests concerning the "csp" package.
 */
public class MainUnitCSP implements IsTestable
{
    @Override
    public boolean allTests() 
    {
        boolean ok = true;

        //Test ArcConsistency
        TestArcConsistency testArcConsistency = new TestArcConsistency();
        ok = ok && testArcConsistency.allTests();
        System.out.println("");
        
        //Test CSP
        TestAbstractSolver testAbstractSolver = new TestAbstractSolver();
        ok = ok && testAbstractSolver.allTests();
        System.out.println("");
        TestBacktrackSolver testBacktrackSolver = new TestBacktrackSolver();
        ok = ok && testBacktrackSolver.allTests();
        System.out.println("");

        return ok;
    }
}
