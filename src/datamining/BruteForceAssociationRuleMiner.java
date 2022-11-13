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

    private BooleanDatabase database;

    public BruteForceAssociationRuleMiner(BooleanDatabase database) {
        super(database);
    }

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
        System.out.println("ok");
        Set<Itemset> itemsets = miner.extract(minFrequency);
        System.out.println("ok, there's no error here");

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
