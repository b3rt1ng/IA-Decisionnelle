package datamining;

import java.util.Set;
import java.util.HashSet;

import representation.BooleanVariable;

public abstract class AbstractAssociationRuleMiner implements AssociationRuleMiner {
    
    private BooleanDatabase database;
    
    public AbstractAssociationRuleMiner(BooleanDatabase database) {
        this.database = database;
    }

    public static float frequency(Set<BooleanVariable> items, Set<Itemset> itemset) {
        for (Itemset item : itemset) {
            if (items.equals(item.getItems())) {
                return item.getFrequency();
            }
        }
        throw new IllegalArgumentException("The itemset is not in the database");
    }

    public static float confidence(Set<BooleanVariable> premice, Set<BooleanVariable> conclusion, Set<Itemset> itemset) {
        
        float frequencyPremice = frequency(premice, itemset);
        float frequencyPremiceConclusion = frequency(conclusion, itemset);
        Set<BooleanVariable> union = new HashSet<BooleanVariable>(premice);
        union.addAll(conclusion);
        for (Itemset it : itemset) {

            if (union.equals(it.getItems()))
                frequencyPremice = it.getFrequency();

            if (union.equals(it.getItems()))
                frequencyPremiceConclusion = it.getFrequency();
        }

        if (frequencyPremice >= 0 && frequencyPremiceConclusion >= 0)
            return frequencyPremiceConclusion / frequencyPremice;
        
        return (float) 0;
    }
    
    @Override
    public BooleanDatabase getDataBase() {
        return this.database;
    }
}
