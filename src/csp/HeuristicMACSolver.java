package csp;

import java.util.Map;
import java.util.Set;

import representation.Constraint;
import representation.Variable;

public class HeuristicMACSolver extends AbstractSolver
{
    private VariableHeuristic variableHeuristic;
    private ValueHeuristic valueHeuristic;

    HeuristicMACSolver(Set<Variable> variables, Set<Constraint> contraintes, VariableHeuristic variableHeuristic, ValueHeuristic valueHeuristic)
    {
        super(variables, contraintes);
        this.variableHeuristic = variableHeuristic;
        this.valueHeuristic = valueHeuristic;
    }

    @Override
    public Map<Variable, Object> solve() 
    {
        return null;
    }
}
