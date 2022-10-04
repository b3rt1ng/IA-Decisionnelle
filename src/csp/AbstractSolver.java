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
    
    public boolean evaluer(Map<Variable, Object> affectation) {
        for (Constraint c : this.contraintes) {
            if (!(c.isSatisfiedBy(affectation))) {
             return false;   
            }
        }
        return true;
    }
    
    public boolean isConsistent(Map<Variable, Object> affectation) {
        if (this.variables.equals(affectation.keySet())) {
            if (evaluer(affectation)){
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}
