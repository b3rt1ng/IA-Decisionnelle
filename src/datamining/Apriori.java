package datamining;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import representation.BooleanVariable;

// j'en suis à l'exo 8

public class Apriori extends AbstractItemsetMiner {

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

    // exo 10
    @Override
    public Set<Itemset> extract(float minFrequency) {
        TreeSet<BooleanVariable> result = new TreeSet<BooleanVariable>(COMPARATOR);
        return null;
    }

    
}
