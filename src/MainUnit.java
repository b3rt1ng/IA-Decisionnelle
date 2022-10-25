import unit.*;

/**
 * Class containing all functions to tests all classes of the project.
 * 
 * @author Kenzo LECOINDRE
 */
public class MainUnit implements IsTestable
{
    /**
     * Launch all the tests of each packages.
     * 
     * @return true if all tests are ok, false otherwhise.
     */
    public boolean allTests()
    {
        boolean ok = true;

        //test representation
        ok = ok && new MainUnitRepresentation().allTests();

        //test planning
        ok = ok && new MainUnitPlanning().allTests();

        //test csp
        ok = ok && new MainUnitCSP().allTests();

        return ok;
    }

    public static void main(String[] args) 
    {   
        MainUnit mainUnit = new MainUnit();
        System.err.println(mainUnit.allTests() ? " All tests of all packages are OK " : " At least one test of a package is KO " );
    }
}