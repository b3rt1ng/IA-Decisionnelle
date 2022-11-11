package datamining;

import java.util.Set;

import representation.BooleanVariable;

/**
 * Class representing an Itemset.
 * 
 * @author Antoine Collenot, Kenzo Lecoindre
 */
public class Itemset {
    
    /**
     * The set of items contained in the itemset.
     */
    private Set<BooleanVariable> items;

    /**
     * a frequency between 0,0 and 1,0.
     */
    private float frequency;

    /**
     * Constructor for the Itemset class.
     * 
     * @param items A set of Boolean Variable.
     * @param frequency A frequency between 0,0 and 1,0.
     */
    public Itemset(Set<BooleanVariable> items, float frequency) {
        this.items = items;
        this.frequency = frequency;
    }

    
    /** 
     * getter for the items.
     * 
     * @return The set of items contained in the itemset.
     */
    public Set<BooleanVariable> getItems() {
        return this.items;
    }

    
    /** 
     * getter for the frequency.
     * 
     * @return The frequency of the itemset.
     */
    public float getFrequency() {
        return this.frequency;
    }
}
