package representation;

import java.util.Map;
import java.util.Set;
import java.util.HashSet;

public class UnaryConstraint implements Constraint {
    
    Variable v1;
    Set<Object> s1;

    public UnaryConstraint(Variable v1, Set<Object> s1) {
        this.v1 = v1;
        this.s1 = s1;   
    }

    public Set<Variable> getScope() {
        Set<Variable> scope = new HashSet<Variable>();
        scope.add(v1);
        return scope;
    }

    public boolean isSatisfiedBy(Map<Variable, Object> instance) {
        if (!(instance.keySet().contains(this.v1)))
            throw new IllegalArgumentException("V1 isn't present in the given instance !");
        
        return this.s1.contains(instance.get(this.v1));
    }
}

