package unit;

import unit.planning.*;

/**
 * @author Kenzo Lecoindre
 * 
 * Contains all the tests concerning the "planning" package.
 */
public class MainUnitPlanning implements IsTestable
{
    @Override
    public boolean allTests() 
    {
        boolean ok = true;

        //Test Action
        TestBasicAction testBasicAction = new TestBasicAction();
        ok = ok && testBasicAction.allTests();
        System.err.println("");

        //Test Goal
        TestBasicGoal testBasicGoal = new TestBasicGoal();
        ok = ok && testBasicGoal.allTests();
        System.err.println("");
        
        //Test Planners
        TestDFSPlanner testDFSPlanner = new TestDFSPlanner();
        ok = ok && testDFSPlanner.allTests();
        System.err.println("");
        TestBFSPlanner testBFSPlanner = new TestBFSPlanner();
        ok = ok && testBFSPlanner.allTests();
        System.err.println("");
        TestDijkstraPlanner testDijkstraPlanner = new TestDijkstraPlanner();
        ok = ok && testDijkstraPlanner.allTests();
        System.err.println("");
        TestAStarPlanner testAStarPlanner = new TestAStarPlanner();
        ok = ok && testAStarPlanner.allTests();
        System.err.println("");

        System.err.println(ok ? " All tests of the package 'planning' are OK " : " At least one test of the package 'planning' is KO " );
        System.err.println("");
        System.err.println("");
        
        return ok;
    }
}
