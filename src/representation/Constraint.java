package representation;

import java.util.*;

/**
 * Interface representing the blueprint of a Constraint.
 * 
 * @author Antoine Collenot
 */

public interface Constraint 
{
    /** 
     * Returns a set of variables to which the constraint applies.
     * 
     * @return the variables from the vurrent constraint.
     */
    public Set<Variable> getScope();

    /**
     * @param instance An instance ton compare to.
     * @return Wheter or not an instance satisfy the current constraint.
     */
    public boolean isSatisfiedBy(Map<Variable, Object> instance);
}
