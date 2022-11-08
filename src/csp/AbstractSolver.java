package csp;

import java.util.Map;
import java.util.Set;

import representation.Constraint;
import representation.Variable;

/**
 * Abstract class that implements the Solver interface.
 * 
 * @author Antoine Collenot, Kenzo Lecoindre
 */

/**
 * 
 */
public abstract class AbstractSolver implements Solver {
    
    /**
     * A set of variables.
     */
    public Set<Variable> variables;

    /**
     * A set of constraints.
     */
    public Set<Constraint> contraintes;

    /**
     * Constructor for the AbstractSolver class.
     * 
     * @param variables A set of variables.
     * @param contraintes A set of constraints.
     */
    public AbstractSolver(Set<Variable> variables, Set<Constraint> contraintes) {
        this.variables = variables;
        this.contraintes = contraintes;
    }
    
    
    /** 
     * Method that checks if a partial affectation is consistent.
     * 
     * @param affectation a partial affectation of the variables.
     * @return wether the given affectation is consistent with the constraints or not.
     */
    public boolean isConsistent(Map<Variable, Object> affectation) {
        for (Constraint constraint : this.contraintes) {
            if (affectation.keySet().containsAll(constraint.getScope())){
                if(!constraint.isSatisfiedBy(affectation))
                    return false;
            }
        }
        return true;
    }
}
