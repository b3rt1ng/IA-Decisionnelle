package datamining;

import java.util.Set;

/**
 * interface representing a miner of association rules
 *
 * @author Antoine Collenot, Kenzo Lecoindre
 */

public interface AssociationRuleMiner {
    
    public BooleanDatabase getDataBase();

    /**
     * compute the set of frequency and confidence association rules above the thresholds given
     * @param minFrequency the minimum frequency threshold
     * @return the set of association rules above the given thresholds
     */
    public Set<AssociationRule> extract(float minFrequency, float minConfidence);
}
