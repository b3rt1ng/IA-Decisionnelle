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

    public Map<Variable, Object> BT(Map<Variable, Object> ParsInst, LinkedList<Variable> unvars) {
        if (unvars.isEmpty())
            return ParsInst;
        Variable xi = unvars.poll();
        for (Object vi : xi.getDomain()) {
            Map<Variable, Object> N = new HashMap<>();
            N.put(xi, vi);
            if (isConsistent(N)) {
                Map<Variable, Object> R = BT(N, unvars);
                if (!R.equals(null)) {
                    return R;
                }
            }
        }
        unvars.add(xi);
        return null;
    }

    @Override
    public Map<Variable, Object> solve() {
        Map<Variable, Object> ParsInst = new HashMap<>(); //instantiation partielle
        return BT(ParsInst, new LinkedList<>(this.variables));
    }
}
