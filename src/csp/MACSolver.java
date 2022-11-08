package csp;

import java.util.Set;
import java.util.Map;
import java.util.LinkedList;
import java.util.HashMap;

import representation.Constraint;
import representation.Variable;

/**
 * Class representing a MAC solver.
 * 
 * @author Antoine Collenot, Kenzo Lecoindre
 */
public class MACSolver extends AbstractSolver {

    /**
     * An Arc Consistency instance.
     */
    private ArcConsistency ac;

    /**
     * Constructor for the MACSolver class.
     * 
     * @param variables A set of variables.
     * @param contraintes A set of constraints.
     */
    public MACSolver(Set<Variable> variables, Set<Constraint> constraints) {
        super(variables, constraints);
        this.ac = new ArcConsistency(constraints);
    }
    
    @Override
    public Map<Variable, Object> solve() {
        Map<Variable, Object> parsInst = new HashMap<>();
        Map<Variable, Set<Object>> ensDomaines = new HashMap<>();
        return mac(parsInst, new LinkedList<>(this.variables), ensDomaines);
    }

    
    /** 
     * Method that implements the MAC algorithm. 
     * 
     * @param ensDomaines the set of domains.
     * @return A solution extending the partial affectation, or null if no solution exists.
     */
    public Map<Variable, Object> mac(Map<Variable, Object> parsInst, LinkedList<Variable> unvars, Map<Variable, Set<Object>> ensDomaines) {
        if (unvars.isEmpty()) {
            return parsInst;
        } else {
            if (!ac.ac1(ensDomaines))
                return null;
            Variable xi = unvars.poll();
            for (Object vi : xi.getDomain()) {
                Map<Variable, Object> n = new HashMap<>(parsInst);
                n.put(xi, vi);
                if (isConsistent(n)) {
                    Map<Variable, Object> r = mac(n, unvars, ensDomaines);
                    if (r!=null) {
                        return r;
                    }
                }
            }
            unvars.add(xi);
            return null;
        }
    }
}