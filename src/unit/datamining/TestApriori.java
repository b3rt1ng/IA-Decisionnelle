package unit.datamining;

import dataminingtests.AprioriTests;
import unit.IsTestable;

/**
 * Class containing all functions to tests all functions of the class AbstractAssociationRuleMinerTests.
 * 
 * @author Antoine Collenot, Kenzo Lecoindre
 */

public class TestApriori {
    /**
     * Launch all the tests concerning this class.
     * 
     * @return true if all tests are ok, false otherwhise.
     */
    public boolean allTests() {

        boolean ok = true;

        // ok = ok && AprioriTests.testFrequentSingletons();
        ok = ok && AprioriTests.testCombine();
        // ok = ok && AprioriTests.testAllSubsetsFrequent();
        ok = ok && AprioriTests.testExtract();

        return ok;
    }
}
