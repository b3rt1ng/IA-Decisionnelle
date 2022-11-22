package datamining;

import java.util.Set;
import java.util.HashSet;

import representation.BooleanVariable;

/**
 * abstract class representing an association rule miner.
 * 
 * @author Antoine Collenot, Kenzo Lecoindre
 */
public abstract class AbstractAssociationRuleMiner implements AssociationRuleMiner {
    
    /**
     * A boolean database.
     */
    protected BooleanDatabase database;
    
    /**
     * Constructor for the AbstractAssociationRuleMiner class.
     * @param database A boolean database.
     */
    public AbstractAssociationRuleMiner(BooleanDatabase database) {
        this.database = database;
    }

    /**
     * 
     * @param items A set of items (boolean variables).
     * @param itemset A set of items (item set).
     * @return The frequency of the itemset if it is in the database.
     */
    public static float frequency(Set<BooleanVariable> items, Set<Itemset> itemset) {
        for (Itemset item : itemset) {
            if (items.equals(item.getItems())) {
                return item.getFrequency();
            }
        }
        throw new IllegalArgumentException("The itemset is not in the database");
    }

    /**
     * 
     * @param premice A set of items (boolean variable).
     * @param conclusion A set of items (boolean variable).
     * @param itemset A set of items (item set).
     * @return The confidence of the premice rule and conclusion.
     */
    public static float confidence(Set<BooleanVariable> premice, Set<BooleanVariable> conclusion, Set<Itemset> itemset) {
        
        float frequencyPremice = -1;
        float frequencyPremiceConclusion = -1;
        Set<BooleanVariable> union = new HashSet<BooleanVariable>(premice);
        union.addAll(conclusion);
        for (Itemset it : itemset) {

            if (premice.equals(it.getItems()))
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
