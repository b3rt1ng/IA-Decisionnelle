import unit.representation.*;

public class MainUnit
{
    public static boolean allTests()
    {
        boolean ok = true;

        System.out.println(TestVariable.allTests() ? " All tests OK " : " At least one test KO " );
        System.out.println("");
        System.out.println(TestBooleanVariable.allTests() ? " All tests OK " : " At least one test KO " );
        System.out.println("");
        System.out.println(TestDifferenceConstraint.allTests() ? " All tests OK " : " At least one test KO " );
        System.out.println("");
        System.out.println(TestImplication.allTests() ? " All tests OK " : " At least one test KO " );
        System.out.println("");
        System.out.println(TestUnaryConstraint.allTests() ? " All tests OK " : " At least one test KO " );

        return ok;
    }

    public static void main(String[] args) 
    {
        System.out.println(MainUnit.allTests() ? " All tests OK " : " At least one test KO " );
    }
}