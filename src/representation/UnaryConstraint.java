package representation;

import java.util.Map;
import java.util.Set;
import java.util.HashSet;

/**
 * Class representing an Unary Constraint.
 * 
 * @author Antoine Collenot
 */

public class UnaryConstraint implements Constraint {
    
    /**
     * Variable meant to be passed to the class in order to check it's satisfaction.
     */
    Variable v1;

    /**
     * Set meant to be passed to the class in order to check it's satisfaction.
     */
    Set<Object> s1;

    /** 
     * Constraint meant to be satisifed if given a variable "v" and a set "S", S has to be a subset of v's domain.
     * 
     * @param v1 a simple variable.
     * @param s1 a set of any type.
     */

    public UnaryConstraint(Variable v1, Set<Object> s1) {
        this.v1 = v1;
        this.s1 = s1;   
    }

    /** 
     * {@inheritdoc}
     */
    public Set<Variable> getScope() {
        Set<Variable> scope = new HashSet<Variable>();
        scope.add(v1);
        return scope;
    }

    /** 
     * This constraint will only be satisifed if given a variable "v" and a set "S", S has to be a subset of v's domain.
     * 
     * {@inheritdoc}
     */
    public boolean isSatisfiedBy(Map<Variable, Object> instance) {
        if (!(instance.keySet().contains(this.v1)))
            throw new IllegalArgumentException("V1 isn't present in the given instance !");
        
        return this.s1.contains(instance.get(this.v1));
    }
}

