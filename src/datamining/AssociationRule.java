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
     * A premice and conclsusion.
     */
    Set<BooleanVariable> premise, conclusion;

    /**
     * A frequency and a confidence.
     */
    float frequence, confidence;

    /**
     * Constructor for the AssociationRule class.
     * 
     * @param premise A set of items (boolean variable).
     * @param conclusion A set of items (boolean variable).
     * @param frequence A frequency.
     * @param confidence A confidence.
     */
    public AssociationRule(Set<BooleanVariable> premise, Set<BooleanVariable> conclusion, float frequence, float confidence) {
        this.premise = premise;
        this.conclusion = conclusion;
        this.frequence = frequence;
        this.confidence = confidence;
    }

    /**
     * Getter for the premise.
     * 
     * @return The premise.
     */
    public Set<BooleanVariable> getPremise() {
        return premise;
    }

    /**
     * Getter for the conclusion.
     * 
     * @return The conclusion.
     */
    public Set<BooleanVariable> getConclusion() {
        return conclusion;
    }

    /**
     * Getter for the frequency.
     * 
     * @return The frequency.
     */
    public float getFrequency() {
        return frequence;
    }

    /**
     * Getter for the confidence.
     * 
     * @return The confidence.
     */
    public float getConfidence() {
        return confidence;
    }
}
