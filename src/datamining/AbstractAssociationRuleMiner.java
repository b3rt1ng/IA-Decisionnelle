package datamining;

import java.util.Set;
import java.util.HashSet;

import representation.BooleanVariable;

/**
 * Abstract class representing an Association Rule miner.
 * 
 * @author Antoine Collenot, Kenzo Lecoindre
 */

public abstract class AbstractAssociationRuleMiner implements AssociationRuleMiner {
    
    /**
     * The boolean database.
     */
    private BooleanDatabase database;
    
    /**
     * Constructor for an Association Rule miner.
     * @param database the database to mine
     */
    public AbstractAssociationRuleMiner(BooleanDatabase database) {
        this.database = database;
    }

    /**
     * This method calculates the frequency of an item in an itemset.
     * 
     * @param items an item to calculatre the frequency ofS
     * @param itemset an itemset to calculate the frequency of the given item
     * @return the frequency of the given item in the given itemset
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
     * @param premice a premice
     * @param conclusion a conclusion
     * @param itemset a set of itemsets
     * @return the confidence of the association rule of the premice and conclusion
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
