package csp;

import java.util.Map;

import representation.Variable;

/**
 * Interface for a CSP solver.
 * 
 * @author Antoine Collenot, Kenzo Lecoindre
 */

public interface Solver {

    /**
     * Solve the CSP.
     * 
     * @return A solution for the CSP, or null if no solution exists.
     */
    public Map<Variable, Object> solve(); //returns null si pas de solution
}
