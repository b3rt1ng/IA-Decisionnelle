package datamining;

import java.util.Set;

import representation.BooleanVariable;
/**
 * Class representing an association rule.
 *
 * @author Antoine Collenot, Kenzo Lecoindre
 */
public class AssociationRule {

    /**
     * The premice and conclusion of the association rule.
     */
    Set<BooleanVariable> premise, conclusion;

    /**
     * The frequency and confidence of the association rule.
     */
    float frequence, confidence;

    /**
     * Constructor for an association rule.
     * 
     * @param premise the premise of the association rule
     * @param conclusion the conclusion of the association rule
     * @param frequence the frequency of the association rule
     * @param confidence the confidence of the association rule
     */
    public AssociationRule(Set<BooleanVariable> premise, Set<BooleanVariable> conclusion, float frequence, float confidence) {
        this.premise = premise;
        this.conclusion = conclusion;
        this.frequence = frequence;
        this.confidence = confidence;
    }

    public Set<BooleanVariable> getPremise() {
        return premise;
    }

    public Set<BooleanVariable> getConclusion() {
        return conclusion;
    }

    public float getFrequency() {
        return frequence;
    }

    public float getConfidence() {
        return confidence;
    }
}
