package csp;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import representation.Constraint;
import representation.Variable;

/**
 * A class representing an Heuristic MACSolver.
 */
public class HeuristicMACSolver extends AbstractSolver
{
    /**
     * An heuristic for the variables.
     */
    private VariableHeuristic variableHeuristic;

    /**
     * An heuristic for the values.
     */
    private ValueHeuristic valueHeuristic;

    /**
     * An Arc Consistency instance.
     */
    private ArcConsistency arcConsistency;

    /**
     * Constructor for the HeuristicMACSolver class.
     * 
     * @param variables A set of variables.
     * @param contraintes A set of constraints.
     * @param variableHeuristic An heuristic for the variables.
     * @param valueHeuristic An heuristic for the values.
     */
    public HeuristicMACSolver(Set<Variable> variables, Set<Constraint> contraintes, VariableHeuristic variableHeuristic, ValueHeuristic valueHeuristic)
    {
        super(variables, contraintes);
        this.variableHeuristic = variableHeuristic;
        this.valueHeuristic = valueHeuristic;
        this.arcConsistency = new ArcConsistency(contraintes);
    }

    
    @Override
    public Map<Variable, Object> solve() 
    {
        Map<Variable, Set<Object>> ensDomaines = new HashMap<>();

        for(Variable v : this.variables)
            ensDomaines.put(v, v.getDomain());

        return macHeuristic(new HashMap<>(), new HashSet<>(this.variables), ensDomaines);
    }

    /**
     * Method that implements the MAC algorithm with heuristics.
     * 
     * @param res 
     * @param unvars the set of unassigned variables.
     * @param ensDomaines the set of domains.
     * @return A solution extending the partial affectation, or null if no solution exists.
     */
    private Map<Variable, Object> macHeuristic(Map<Variable, Object> res, Set<Variable> unvars, Map<Variable, Set<Object>> ensDomaines)
    {
        if(unvars.isEmpty())
            return res;
        
        if(!this.arcConsistency.ac1(ensDomaines))
            return null;
        
        Variable xi = this.variableHeuristic.best(unvars, ensDomaines);
        unvars.remove(xi);

        for(Object vi : this.valueHeuristic.ordering(xi, ensDomaines.get(xi))) 
        {
            Map<Variable, Object> tmpRes = new HashMap<>(res);
            tmpRes.put(xi, vi);
            if(isConsistent(tmpRes)) 
            {
                Map<Variable, Object> newRes = macHeuristic(tmpRes, unvars, ensDomaines);
                
                if(newRes != null)
                    return newRes;
            }
        }

        unvars.add(xi);
        return null;
    }
}
