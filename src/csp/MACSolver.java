package csp;

import java.util.Set;
import java.util.Map;
import java.util.LinkedList;
import java.util.HashMap;


import representation.Constraint;
import representation.Variable;

public class MACSolver extends AbstractSolver {

    public MACSolver(Set<Variable> variables, Set<Constraint> constraints) {
        super(variables, constraints);   
    }

    //A finir
    @Override
    public Map<Variable, Object> solve() {
        Map<Variable, Object> parsInst = new HashMap<>();
        LinkedList<Variable> unvars = new LinkedList<>(this.variables);
        return null;
    }
}