package unit.csp;

import csptests.SolverTests;

import unit.IsTestable;
import csp.HeuristicMACSolver;
import csp.NbConstraintsVariableHeuristic;
import csp.RandomValueHeuristic;

public class TestHeuristicMACSolver implements IsTestable 
{

    @Override
    public boolean allTests() 
    {
        boolean ok = true;
        
        /*
        ok = ok && new SolverTests (
            ( vars, constraints ) -> new HeuristicMACSolver(vars, constraints, new NbConstraintsVariableHeuristic(), new RandomValueHeuristic())
        ).testSolve();
        */
        
        return ok;
    }
    
}
