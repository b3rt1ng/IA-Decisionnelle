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

        //Tests Backtrack
        TestAbstractSolver testAbstractSolver = new TestAbstractSolver();
        ok = ok && testAbstractSolver.allTests();
        System.out.println("");
        TestBacktrackSolver testBacktrackSolver = new TestBacktrackSolver();
        ok = ok && testBacktrackSolver.allTests();
        System.out.println("");

        //Tests Coherence d'arc et MAC
        TestArcConsistency testArcConsistency = new TestArcConsistency();
        ok = ok && testArcConsistency.allTests();
        System.out.println("");
        TestMACSolver testMACSolver = new TestMACSolver();
        ok = ok && testMACSolver.allTests();
        System.out.println("");
        
        //Tests Heuristiques
        TestNbConstraintsVariableHeuristic testNbConstraintsVariableHeuristic = new TestNbConstraintsVariableHeuristic();
        ok = ok && testNbConstraintsVariableHeuristic.allTests();
        System.out.println("");
        TestDomainSizeVariableHeuristic testDomainSizeVariableHeuristic = new TestDomainSizeVariableHeuristic();
        ok = ok && testDomainSizeVariableHeuristic.allTests();
        System.out.println("");
        TestRandomValueHeuristic testRandomValueHeuristic = new TestRandomValueHeuristic();
        ok = ok && testRandomValueHeuristic.allTests();
        System.out.println("");
        TestHeuristicMACSolver testHeuristicMACSolver = new TestHeuristicMACSolver();
        ok = ok && testHeuristicMACSolver.allTests();
        System.out.println("");

        System.out.println(ok ? " All tests of the package 'csp' are OK " : " At least one test of the package 'csp' is KO " );
        System.out.println("");
        System.out.println("");

        return ok;
    }
}
