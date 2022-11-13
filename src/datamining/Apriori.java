package datamining;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.LinkedList;
import java.util.List;

import representation.BooleanVariable;

/**
 * Class representing an "Apriori".
 * 
 * @author Antoine Collenot, Kenzo Lecoindre
 */
public class Apriori extends AbstractItemsetMiner {

    /**
     * Constructor for the Apriori class.
     * 
     * @param base A boolean database.
     */
    public Apriori(BooleanDatabase base) {
        super(base);
    }

    /**
     * This function is meant to return a set of Itemset that are equally frequent or more than a givent frequency
     * 
     * @param frequency The frequency to at least surpass
     * @return a set of Itemset that are equally frequent or more than a givent frequency
     */
    public Set<Itemset> frequentSingletons(float frequency) {

        Set<Itemset> result = new HashSet<Itemset>();

        for (BooleanVariable item : this.base.getItems()) {
            if (this.frequency(Set.of(item)) >= frequency) {
                result.add(new Itemset(Set.of(item), this.frequency(Set.of(item))));
            }
        }
        return result;
    }

    /**
     * This method will return the combination of the two given itemset if the following conditions are valid:
     *  -the two sets have the same size k
     *  -the two sets have the same k − 1 first items
     *  -the two sets have k different items
     * 
     * @param firstEns The first set of items
     * @param secondEns The second set of items
     * @return a sorted set of items matching the three required conditions or null if the conditions are not met
     */
    public static SortedSet<BooleanVariable> combine(SortedSet<BooleanVariable> firstEns, SortedSet<BooleanVariable> secondEns) {

        if (firstEns.size() == secondEns.size() && firstEns.size()!=0){
            if (firstEns.headSet(firstEns.last()).equals(secondEns.headSet(secondEns.last()))) {
                if (!firstEns.last().equals(secondEns.last())) {
                    SortedSet<BooleanVariable> result = new TreeSet<BooleanVariable>(COMPARATOR);
                    result.addAll(firstEns);
                    result.addAll(secondEns);
                    return result;                    
                }
            }
        }
        return null;
    }

    /**
     * 
     * @param ensemble A set of items
     * @param colEnsemble A collection of sets of items
     * @return true if all subsets obtained by deleting exactly one element of the set of items are contained in the collection, false otherwise
     */
    public static Boolean allSubsetsFrequent(Set<BooleanVariable> ensemble, Collection<SortedSet<BooleanVariable>> colEnsemble) {

        TreeSet<BooleanVariable> temp = new TreeSet<BooleanVariable>(COMPARATOR);
        temp.addAll(ensemble);

        for (BooleanVariable it : ensemble) {
            temp.remove(it);
            if (!colEnsemble.contains(temp)) {
                return false;
            }
            temp.add(it);
        }
        return true;
    }

    @Override
    public Set<Itemset> extract(float minFrequency) {
        Set<Itemset> result = new HashSet<>();
        result.addAll(frequentSingletons(minFrequency));
        List<SortedSet<BooleanVariable>> kFoundItemsets = new LinkedList<>();

        for (Itemset singleton : result) {
            SortedSet<BooleanVariable> temp = new TreeSet<BooleanVariable>(COMPARATOR);
            temp.addAll(singleton.getItems());
            kFoundItemsets.add(temp);
        }

        while (!kFoundItemsets.isEmpty() && kFoundItemsets.get(0).size() < this.base.getItems().size()) {
            List<SortedSet<BooleanVariable>> kPlusOneFoundItemsets = new LinkedList<>();
            for (int i = 0; i < kFoundItemsets.size(); i++) {
                for (int j = i + 1; j < kFoundItemsets.size(); j++) {
                    SortedSet<BooleanVariable> temp = combine(kFoundItemsets.get(i), kFoundItemsets.get(j));
                    if (temp != null) {
                        if (allSubsetsFrequent(temp, kFoundItemsets)) {
                            kPlusOneFoundItemsets.add(temp);
                        }
                    }
                }
            }
            for (SortedSet<BooleanVariable> itemset : kPlusOneFoundItemsets) {
                if (this.frequency(itemset) >= minFrequency) {
                    result.add(new Itemset(itemset, this.frequency(itemset)));
                }
            }
            kFoundItemsets = kPlusOneFoundItemsets;
        }
        return null;
    }

    
}
