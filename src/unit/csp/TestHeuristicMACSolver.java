package unit.csp;

import csptests.SolverTests;

import unit.IsTestable;

import java.util.ArrayList;
import java.util.Random;

import csp.HeuristicMACSolver;
import csp.NbConstraintsVariableHeuristic;
import csp.DomainSizeVariableHeuristic;
import csp.RandomValueHeuristic;

public class TestHeuristicMACSolver implements IsTestable 
{
    @Override
    public boolean allTests() 
    {
        boolean ok = true;

        //Test NbConstraintsVariableHeuristic avec RandomValueHeuristic
        ok = ok && new SolverTests (
            ( vars, constraints) -> new HeuristicMACSolver(vars, constraints, new NbConstraintsVariableHeuristic(constraints, true), new RandomValueHeuristic(new Random()))
        ).testSolve();

        //Test DomainSizeVariableHeuristic avec RandomValueHeuristic
        ok = ok && new SolverTests (
            ( vars, constraints) -> new HeuristicMACSolver(vars, constraints, new DomainSizeVariableHeuristic(false), new RandomValueHeuristic(new Random()))
        ).testSolve();
        
        return ok;
    }
    
}
