package unit.csp;

import csptests.DomainSizeVariableHeuristicTests;

import unit.IsTestable;

public class TestDomainSizeVariableHeuristic implements IsTestable
{
    @Override
    public boolean allTests() 
    {
        boolean ok = true;
        
        ok = ok && DomainSizeVariableHeuristicTests.testBest();
        
        return ok;
    }
}
