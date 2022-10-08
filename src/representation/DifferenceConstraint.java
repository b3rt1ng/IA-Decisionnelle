package representation;

import java.util.Map;
import java.util.Set;
import java.util.HashSet;

/**
 * Class representing a Difference Constraint.
 * 
 * @author Antoine Collenot
 */

public class DifferenceConstraint implements Constraint {

    Variable v1,v2; 

    public DifferenceConstraint(Variable v1, Variable v2) {
        this.v1 = v1;
        this.v2 = v2;
    }

    
    /** 
     * Returns a set of variables to which the constraint applies.
     * 
     * @return Set<Variable>
     */
    public Set<Variable> getScope() {
        Set<Variable> scope = new HashSet<Variable>();
        scope.add(v1);
        scope.add(v2);
        return scope;
    }

    
    /** 
     * Returns wheter or not an instance satisfy the current constraint.
     * This constraint will only be satisifed if given two variables v1 and v2, v1 is different from v2.
     * 
     * @param instance
     * @return boolean
     */
    public boolean isSatisfiedBy(Map<Variable, Object> instance) {
        if (!(instance.keySet().contains(this.v1) && instance.keySet().contains(this.v2)))
            throw new IllegalArgumentException("V1 or V2 aren't present in the given instance !");
        return !(instance.get(this.v1).equals(instance.get(this.v2)));
    }
}