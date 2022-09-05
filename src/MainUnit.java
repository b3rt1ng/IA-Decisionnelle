import unit.representation.*;

public class MainUnit
{
    public MainUnit()
    {
        System.out.println(TestVariable.allTests() ? " All tests OK " : " At least one test KO " );
        System.out.println("");
        System.out.println(TestBooleanVariable.allTests() ? " All tests OK " : " At least one test KO " );
        System.out.println("");
        System.out.println(TestDifferenceConstraint.allTests() ? " All tests OK " : " At least one test KO " );
        System.out.println("");
        System.out.println(TestImplication.allTests() ? " All tests OK " : " At least one test KO " );
        System.out.println("");
        System.out.println(TestUnaryConstraint.allTests() ? " All tests OK " : " At least one test KO " );
    }

    public static void main(String[] args) 
    {
        new MainUnit();
    }
}