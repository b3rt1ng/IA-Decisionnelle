package csp;

import java.util.Map;
import java.util.Set;


import representation.Constraint;
import representation.Variable;

public abstract class AbstractSolver implements Solver {
    
    public Set<Variable> variables;
    public Set<Constraint> contraintes;

    public AbstractSolver(Set<Variable> variables, Set<Constraint> contraintes) {
        this.variables = variables;
        this.contraintes = contraintes;
    }
    
    public boolean isConsistent(Map<Variable, Object> affectation) {
        for (Constraint constraint : this.contraintes) {
            if (affectation.keySet().containsAll(constraint.getScope())){
                if(!constraint.isSatisfiedBy(affectation))
                    return false;
            }
        }
        return false;
    }
}
