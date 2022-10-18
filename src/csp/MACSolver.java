package csp;

import java.util.Set;
import java.util.Map;
import java.util.LinkedList;
import java.util.HashMap;


import representation.Constraint;
import representation.Variable;

public class MACSolver extends AbstractSolver {

    private ArcConsistency ac;

    public MACSolver(Set<Variable> variables, Set<Constraint> constraints) {
        super(variables, constraints);
        this.ac = new ArcConsistency(constraints);
    }
    
    @Override
    public Map<Variable, Object> solve() {
        Map<Variable, Object> parsInst = new HashMap<>(); //instantiation partielle
        Map<Variable, Set<Object>> ensDomaines = new HashMap<>();
        return mac(parsInst, new LinkedList<>(this.variables), ensDomaines);
    }

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