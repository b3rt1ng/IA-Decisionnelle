import unit.planning.TestBFSPlanner;
import unit.planning.TestBasicAction;
import unit.planning.TestBasicGoal;
import unit.planning.TestDFSPlanner;
import unit.representation.*;

public class MainUnit
{
    public static boolean allTests()
    {
        boolean ok = true;

        //Test Variables
        System.out.println(TestVariable.allTests() ? " All tests OK " : " At least one test KO " );
        System.out.println("");
        System.out.println(TestBooleanVariable.allTests() ? " All tests OK " : " At least one test KO " );
        System.out.println("");

        //Test Contraintes
        /*
        System.out.println(TestDifferenceConstraint.allTests() ? " All tests OK " : " At least one test KO " );
        System.out.println("");
        System.out.println(TestImplication.allTests() ? " All tests OK " : " At least one test KO " );
        System.out.println("");
        System.out.println(TestUnaryConstraint.allTests() ? " All tests OK " : " At least one test KO " );
        */

        //Test Action
        System.out.println(TestBasicAction.allTests() ? " All tests OK " : " At least one test KO " );
        System.out.println("");

        //Test Goal
        System.out.println(TestBasicGoal.allTests() ? " All tests OK " : " At least one test KO " );
        System.out.println("");
        
        //Test Planners
        System.out.println(TestDFSPlanner.allTests() ? " All tests OK " : " At least one test KO " );
        System.out.println("");
        System.out.println(TestBFSPlanner.allTests() ? " All tests OK " : " At least one test KO " );
        System.out.println("");

        return ok;
    }

    public static void main(String[] args) 
    {
        System.out.println(MainUnit.allTests());
    }
}