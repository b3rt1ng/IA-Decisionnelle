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
        System.out.println("");

        //Test Goal
        TestBasicGoal testBasicGoal = new TestBasicGoal();
        ok = ok && testBasicGoal.allTests();
        System.out.println("");
        
        //Test Planners
        TestDFSPlanner testDFSPlanner = new TestDFSPlanner();
        ok = ok && testDFSPlanner.allTests();
        System.out.println("");
        TestBFSPlanner testBFSPlanner = new TestBFSPlanner();
        ok = ok && testBFSPlanner.allTests();
        System.out.println("");
        TestDijkstraPlanner testDijkstraPlanner = new TestDijkstraPlanner();
        ok = ok && testDijkstraPlanner.allTests();
        System.out.println("");
        TestAStarPlanner testAStarPlanner = new TestAStarPlanner();
        ok = ok && testAStarPlanner.allTests();
        System.out.println("");

        return ok;
    }
}
