package csp;

import java.util.Set;
import java.util.Map;

import representation.Variable;

public interface VariableHeuristic {
    public Variable best(Set<Variable> vars,Map<Variable, Set<Object>> domains);
}