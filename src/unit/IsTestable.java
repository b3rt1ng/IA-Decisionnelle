package unit;

/**
 * @author Kenzo Lecoindre
 * 
 * Interface to test if a unit is testable and containing
 * the method to launch all the tests.
 */
public interface IsTestable 
{
    /**
     * Launch all the tests concerning this class.
    */
    public boolean allTests();
}