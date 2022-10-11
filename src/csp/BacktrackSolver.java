package csp;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.LinkedList;

import representation.Constraint;
import representation.Variable;

public class BacktrackSolver extends AbstractSolver {
    
    public BacktrackSolver(Set<Variable> variables, Set<Constraint> contraintes) {
        super(variables, contraintes);
    }

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
