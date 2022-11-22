package datamining;

import java.util.Set;
import java.util.HashSet;

import representation.BooleanVariable;

/**
 * Class representing an Association Rule brute forcer.
 * 
 * @author Antoine Collenot, Kenzo Lecoindre
 */

public class BruteForceAssociationRuleMiner extends AbstractAssociationRuleMiner {

    /**
     * Constructor for the BruteForceAssociationRuleMiner class.
     * 
     * @param database A boolean database.
     */
    public BruteForceAssociationRuleMiner(BooleanDatabase database) {
        super(database);
    }

    /**
     *  This method get all the possible subsets of a set of items (besides the empty set and the set itself).
     * 
     * @param ensItem a set of items
     * @return the set of all subsets of the given set of items besides the empty set and the set itself
     */
    public static Set<Set<BooleanVariable>> allCandidatePremises (Set<BooleanVariable> ensItem) {
        Set<Set<BooleanVariable>> result = new HashSet<Set<BooleanVariable>>();
        Set<Set<BooleanVariable>> mem = new HashSet<Set<BooleanVariable>>();

        for (BooleanVariable item : ensItem) {
            mem.add(Set.of(item));
        }

        int max = (int) Math.pow(2, ensItem.size()) - 1;

        while(result.size() < max) {
            result.addAll(mem);
            Set<Set<BooleanVariable>> temp = new HashSet<Set<BooleanVariable>>();

            for (Set<BooleanVariable> set : mem) {
                for (BooleanVariable item : ensItem) {
                    if (!set.contains(item)) {
                        Set<BooleanVariable> newSet = new HashSet<BooleanVariable>(set);
                        newSet.add(item);
                        temp.add(newSet);
                    }
                }
            }
            mem = temp;
        }
        result.remove(ensItem);
        return result;
    }

    @Override
    public Set<AssociationRule> extract(float minFrequency, float minConfidence) {
        Set<AssociationRule> result = new HashSet<AssociationRule>();
        ItemsetMiner miner = new Apriori(this.database);
        Set<Itemset> itemsets = miner.extract(minFrequency);

        for (Itemset itemset : itemsets) {
            for (Set<BooleanVariable> premise : allCandidatePremises(itemset.getItems())) {

                Set<BooleanVariable > conclusion = new HashSet<BooleanVariable>(itemset.getItems());
                conclusion.removeAll(premise);

                float conf = AbstractAssociationRuleMiner.confidence(premise, conclusion, itemsets);
                AssociationRule rule = new AssociationRule(premise, conclusion, itemset.getFrequency(), conf);
                
                if (rule.getConfidence() >= minConfidence && rule.getFrequency() >= minFrequency) {
                    result.add(rule);
                }
            }
        }
            
        return result;
    }
    
}
