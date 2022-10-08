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
    
    Variable v1;
    Set<Object> s1;

    public UnaryConstraint(Variable v1, Set<Object> s1) {
        this.v1 = v1;
        this.s1 = s1;   
    }

    /** 
     * Returns a set of variables to which the constraint applies.
     * 
     * @return Set<Variable>
     */
    public Set<Variable> getScope() {
        Set<Variable> scope = new HashSet<Variable>();
        scope.add(v1);
        return scope;
    }

    /** 
     * Returns wheter or not an instance satisfy the current constraint.
     * This constraint will only be satisifed if given a variable "v" and a set "S", S has to be a subset of v's domain.
     * 
     * @param instance
     * @return boolean
     */
    public boolean isSatisfiedBy(Map<Variable, Object> instance) {
        if (!(instance.keySet().contains(this.v1)))
            throw new IllegalArgumentException("V1 isn't present in the given instance !");
        
        return this.s1.contains(instance.get(this.v1));
    }
}

