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
        Map<Variable, Set<Object>> ensDomaines = new HashMap<>();
        Map<Variable, Object> parsInst = new HashMap<>();
        LinkedList<Variable> unvars = new LinkedList<>(this.variables);
        if (unvars.isEmpty()) {
            return parsInst;
        } else {
            if (!ac.ac1(ensDomaines)) {
                return null;
            }
        }
        return null;
    }
    // temporaire
}