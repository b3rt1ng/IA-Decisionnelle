package representation;

import java.util.Map;
import java.util.Set;

public class DifferenceConstraint implements Constraint {

    Variable v1,v2;

    public DifferenceConstraint(Variable v1, Variable v2) {
        if v1.equals(v2)
            throw new IllegalArgumentException("les variables v1 et v2 sont les mêmes");
        this.v1 = v1;
        this.v2 = v2;
    }

    public Set<Variable> getScope() {
        Set<Variable> scope = new HashSet<Variable>();
        scope.add(v1);
        scope.add(v2);
        return scope;
    }

    public boolean isSatisfiedBy(Map<Variable, object> instance) {
        if !(instance.KeySet().contains(this.v1) && instace.KeySet().contains(this.v2))
            throw new IllegalArgumentException("V1 or V2 aren't present in the given instance !");
    }

}