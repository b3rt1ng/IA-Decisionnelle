package csp;

import java.util.Set;
import java.util.List;

import representation.Variable;

/**
 * Interface for a Value Heuristic.
 * 
 * @author Antoine Collenot, Kenzo Lecoindre
 */
public interface ValueHeuristic {

    /**
     * 
     * @param var A variable.
     * @param domain The variable's domain.
     * @return The list of values in the domain oredered by the heuristic. 
     */
    public List<Object> ordering(Variable var,Set<Object> domain);
}