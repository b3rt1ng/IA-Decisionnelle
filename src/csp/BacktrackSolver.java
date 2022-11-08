package csp;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.LinkedList;

import representation.Constraint;
import representation.Variable;

/**
 * Class representing a BacktrackSolver.
 * 
 * @author Antoine Collenot, Kenzo Lecoindre
 */
public class BacktrackSolver extends AbstractSolver {
    
    /**
     * Constructor for the BacktrackSolver class.
     * 
     * @param variables A set of variables.
     * @param contraintes A set of constraints.
     */
    public BacktrackSolver(Set<Variable> variables, Set<Constraint> contraintes) {
        super(variables, contraintes);
    }

    
    /** 
     * Method that implements the Backtrack algorithm.
     * 
     * @param parsInst a partial affectation of the variables.
     * @param unvars the set of unassigned variables.
     * @return A solution extending the partial affectation, or null if no solution exists.
     */
    public Map<Variable, Object> bt(Map<Variable, Object> parsInst, LinkedList<Variable> unvars) {
        if (unvars.isEmpty())
            return parsInst;
        Variable xi = unvars.poll();
        for (Object vi : xi.getDomain()) {
            Map<Variable, Object> n = new HashMap<>(parsInst);
            n.put(xi, vi);
            if (isConsistent(n)) {
                Map<Variable, Object> r = bt(n, unvars);
                if (r!=null) {
                    return r;
                }
            }
        }
        unvars.add(xi);
        return null;
    }

    @Override
    public Map<Variable, Object> solve() {
        Map<Variable, Object> parsInst = new HashMap<>(); //instantiation partielle
        return bt(parsInst, new LinkedList<>(this.variables));
    }
}
