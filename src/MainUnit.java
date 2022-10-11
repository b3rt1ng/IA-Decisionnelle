import unit.planning.TestAStarPlanner;
import unit.planning.TestBFSPlanner;
import unit.planning.TestBasicAction;
import unit.planning.TestBasicGoal;
import unit.planning.TestDFSPlanner;
import unit.planning.TestDijkstraPlanner;
import unit.representation.*;
import unit.csp.TestAbstractSolver;
import unit.csp.TestBacktrackSolver;

/**
 * Class containing all functions to tests all classes of the project.
 * 
 * @author Kenzo LECOINDRE
 */
public class MainUnit
{
    /**
     * Launch all the tests that this class concern.
     * 
     * @return true if all tests are ok, false otherwhise.
     */
    public static boolean allTests()
    {
        boolean ok = true;

        //Test Variables
        ok = ok && TestVariable.allTests();
        System.out.println("");
        ok = ok && TestBooleanVariable.allTests();
        System.out.println("");

        //Test Contraintes
        ok = ok && TestDifferenceConstraint.allTests();
        System.out.println("");
        ok = ok && TestImplication.allTests();
        System.out.println("");
        ok = ok && TestUnaryConstraint.allTests();
        System.out.println("");
        
        //Test Action
        ok = ok && TestBasicAction.allTests();
        System.out.println("");

        //Test Goal
        ok = ok && TestBasicGoal.allTests();
        System.out.println("");
        
        //Test Planners
        ok = ok && TestDFSPlanner.allTests();
        System.out.println("");
        ok = ok && TestBFSPlanner.allTests();
        System.out.println("");
        ok = ok && TestDijkstraPlanner.allTests();
        System.out.println("");
        ok = ok && TestAStarPlanner.allTests();
        System.out.println("");

        //Test CSP
        ok = ok && TestAbstractSolver.allTests();
        System.out.println("");
        ok = ok && TestBacktrackSolver.allTests();
        System.out.println("");

        return ok;
    }

    public static void main(String[] args) 
    {   
        System.out.print(MainUnit.allTests() ? " All tests of classes are OK " : " At least one test of the class is KO " );
    }
}