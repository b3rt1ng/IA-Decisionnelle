package datamining;

import java.util.Set;

/**
 * Interface which contains all methods concerning an Action.
 * 
 * @author Kenzo LECOINDRE
 */

public interface ItemsetMiner {
    public BooleanDatabase getDatabase();
    public Set<Itemset> extract(float minFrequency);
}
