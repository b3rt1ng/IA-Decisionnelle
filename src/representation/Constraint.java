package representation;

import java.util.*;

public interface Constraint {

    public Set<Variable> getScope();
    public Boolean isSatisfiedBy(Map<Variable, Object>);
    
}