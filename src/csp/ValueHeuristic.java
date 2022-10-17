package csp;

import java.util.Set;
import java.util.List;

import representation.Variable;

public interface ValueHeuristic {
    public List<Object> ordering(Variable var,Set<Object> domain);
}