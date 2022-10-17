package unit.csp;

import csptests.NbConstraintsVariableHeuristicTests;

import unit.IsTestable;

public class TestNbConstraintsVariableHeuristic implements IsTestable
{
    @Override
    public boolean allTests() 
    {
        boolean ok = true;

        ok = ok && NbConstraintsVariableHeuristicTests.testBest();

        return ok;
    }

} 

