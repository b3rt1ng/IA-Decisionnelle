package representation;

import java.util.*;

/**
 * Interface representing the blueprint of a Constraint.
 * 
 * @author Antoine Collenot
 */

public interface Constraint 
{
    public Set<Variable> getScope();
    public boolean isSatisfiedBy(Map<Variable, Object> instance);
}
