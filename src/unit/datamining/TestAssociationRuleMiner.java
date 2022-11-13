package unit.datamining;

import dataminingtests.AbstractAssociationRuleMinerTests;
import unit.IsTestable;

/**
 * Class containing all functions to tests all functions of the class AbstractAssociationRuleMinerTests.
 * 
 * @author Antoine Collenot, Kenzo Lecoindre
 */

public class TestAssociationRuleMiner {
    /**
     * Launch all the tests concerning this class.
     * 
     * @return true if all tests are ok, false otherwhise.
     */
    public boolean allTests() {

        boolean ok = true;

        // ok = ok && AbstractAssociationRuleMinerTests.testFrequency();
        ok = ok && AbstractAssociationRuleMinerTests.testConfidence();

        return ok;
    }
}
