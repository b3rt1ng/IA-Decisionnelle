package datamining;

import java.util.Set;

/**
 * Interface for itemset miners.
 * 
 * @author Antoine Collenot, Kenzo Lecoindre
 */

public interface ItemsetMiner {

    /**
     * getter for the boolean database.
     * 
     * @return the boolean database
     */
    public BooleanDatabase getDatabase();

    /**
     * 
     * @param minFrequency the minimum frequency to surpass
     * @return the set of (non-empty) itemsets having at least this frequency in the base
     */
    public Set<Itemset> extract(float minFrequency);
}
