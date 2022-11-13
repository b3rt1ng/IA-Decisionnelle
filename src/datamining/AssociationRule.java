package datamining;

import java.util.Set;

import representation.BooleanVariable;
/**
 * Class representing an association rule.
 *
 * @author Antoine Collenot, Kenzo Lecoindre
 */
public class AssociationRule {

    Set<BooleanVariable> premise, conclusion;
    float frequence, confidence;

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
