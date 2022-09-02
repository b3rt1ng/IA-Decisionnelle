package representation;

import java.util.Map;
import java.util.Set;

public class DifferenceConstraint implements Constraint {

    Variable v1;
    Variable v2;

    public DifferenceConstraint(Variable v1, Variable v2) {
        this.v1 = v1;
        this.v2 = v2;
    }

    public Set<Variable> getScope() {
        Set<Variable> scope = new HashSet<Variable>();
        scope.add(v1);
        scope.add(v2);
        return scope;
    }

    public boolean isSatisfiedBy(Map<Variable, Object> instance) {
        
    }

}