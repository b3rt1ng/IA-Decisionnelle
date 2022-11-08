package csp;

import java.util.Set;
import java.util.Map;

import representation.Variable;

/**
 * Interface for a Variable Heuristic.
 * 
 * @author Antoine Collenot, Kenzo Lecoindre
 */
public interface VariableHeuristic {

    /**
     * Method that returns the best varialbe according to the heuristic.
     * 
     * @param vars A set of variables.
     * @param domains A map of variables and their domains.
     * @return A variable choosen depending on the heuristic.
     */
    public Variable best(Set<Variable> vars,Map<Variable, Set<Object>> domains);
}