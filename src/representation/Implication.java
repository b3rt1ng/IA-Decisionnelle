package representation;

import java.util.Map;
import java.util.Set;
import java.util.HashSet;

/**
 * Class representing an Implication.
 * 
 * @author Antoine Collenot
 */

public class Implication implements Constraint {

    /**
     * Variables meant to be passed to the class in order to check it's satisfaction.
     */
    Variable v1,v2;

    /**
     * Sets meant to be passed to the class in order to check it's satisfaction.
     */
    Set<Object> s1,s2;

    /** 
     * Constraint meant to be satisifed if given a v1 affected to a S1 set implies a v2 affected to a S2 set, v1 and v2 being two varaibles.
     * 
     * @param v1 a simple variable.
     * @param v2 a simple variable.
     * @param s1 a set of any type.
     * @param s2 a set of any type.
     */

    public Implication(Variable v1, Set<Object> s1,Variable v2, Set<Object> s2) {
        this.v1 = v1;
        this.v2 = v2;
        this.s1 = s1;
        this.s2 = s2;    
    }

    
    /** 
     * {@inheritdoc}
     */
    public Set<Variable> getScope() {
        Set<Variable> scope = new HashSet<Variable>();
        scope.add(v1);
        scope.add(v2);
        return scope;
    }

    
    /** 
     * This constraint will only be satisifed if given a v1 affected to a S1 set implies a v2 affected to a S2 set, v1 and v2 being two varaibles.
     * 
     * {@inheritdoc}
     */
    public boolean isSatisfiedBy(Map<Variable, Object> instance) {
        if (!(instance.keySet().contains(this.v1) && instance.keySet().contains(this.v2)))
            throw new IllegalArgumentException("V1 or V2 aren't present in the given instance !");
        
        if ((this.s1.contains(instance.get(this.v1)) && this.s2.contains(instance.get(this.v2)))) {
            return true;
        } else if (!this.s1.contains(instance.get(this.v1))) {
            return true;
        }
        return false;
    }
}
