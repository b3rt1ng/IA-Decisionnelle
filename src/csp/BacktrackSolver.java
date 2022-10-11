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
            Map<Variable, Object> N = new HashMap<>(parsInst);
            N.put(xi, vi);
            if (isConsistent(N)) {
                Map<Variable, Object> R = bt(N, unvars);
                if (R!=null) {
                    return R;
                }
            }
        }
        unvars.add(xi);
        return null;
    }

    @Override
    public Map<Variable, Object> solve() {
        Map<Variable, Object> parsInst = new HashMap<>();
        return bt(parsInst, new LinkedList<>(this.variables));
    }
}
