package datamining;

import java.util.Comparator;
import java.util.Set;

import representation.BooleanVariable;

/**
 * Abstract class representing an Itemset Miner.
 * 
 * @author Antoine Collenot, Kenzo Lecoindre
 */
public abstract class AbstractItemsetMiner implements ItemsetMiner {

    /**
     * The boolean database.
     */
    protected BooleanDatabase base;

    /**
     * Constructor for the AbstractItemsetMiner class.
     * 
     * @param base A boolean database.
     */
    public AbstractItemsetMiner(BooleanDatabase base) {
        this.base = base;
    }

    
    /** 
     * Method to get the frequency of a given set of items in the database
     * 
     * @param items 
     * @return the frequency of a given set of items in the database
     */
    public float frequency(Set<BooleanVariable> items) {
        float result = 0;
        for (Set<BooleanVariable> transaction : this.base.getTransactions()) {
            if (transaction.containsAll(items)) {
                result++;
            }
        }
        return result / this.base.getTransactions().size();
    }

    /**
     * Attribute meant to compare two items.
     */
    public static final Comparator<BooleanVariable> COMPARATOR = (var1, var2) -> var1.getName().compareTo(var2.getName());

    
    /** 
     * getter for the boolean database.
     * 
     * @return BooleanDatabase
     */
    public BooleanDatabase getDatabase() {
        return this.base;
    }

}
