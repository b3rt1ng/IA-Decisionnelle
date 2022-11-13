package unit;

import unit.datamining.*;

/**
 * @author Antoine Collenot
 * 
 * Contains all the tests concerning the "datamining" package.
 */
public class MainUnitDatamining implements IsTestable {
    @Override
    public boolean allTests() {
        boolean ok = true;

        //Tests association rules
        TestAssociationRuleMiner testAssociationRuleMiner = new TestAssociationRuleMiner();
        ok = ok && testAssociationRuleMiner.allTests();
        System.err.println("");

        //Tests itemsets
        TestAbstractItemsetMiner testAbstractItemsetMiner = new TestAbstractItemsetMiner();
        ok = ok && testAbstractItemsetMiner.allTests();

        //Tests Apriori
        TestApriori testApriori = new TestApriori();
        ok = ok && testApriori.allTests();

        System.err.println(ok ? " All tests of the package 'datamining' are OK " : " At least one test of the package 'datamining' is KO " );
        System.err.println("");
        System.err.println("");

        return ok;
    }
    
}
