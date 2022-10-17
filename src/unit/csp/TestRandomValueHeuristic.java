package unit.csp;

import csptests.RandomValueHeuristicTests;

import unit.IsTestable;

public class TestRandomValueHeuristic implements IsTestable 
{
    @Override
    public boolean allTests() 
    {
        boolean ok = true;

        ok = ok && RandomValueHeuristicTests.testOrdering();

        return ok;
    }
}