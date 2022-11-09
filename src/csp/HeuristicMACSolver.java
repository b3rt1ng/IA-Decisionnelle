package csp;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import representation.Constraint;
import representation.Variable;

public class HeuristicMACSolver extends AbstractSolver
{
    private VariableHeuristic variableHeuristic;
    private ValueHeuristic valueHeuristic;

    private ArcConsistency arcConsistency;

    public HeuristicMACSolver(Set<Variable> variables, Set<Constraint> contraintes, VariableHeuristic variableHeuristic, ValueHeuristic valueHeuristic)
    {
        super(variables, contraintes);
        this.variableHeuristic = variableHeuristic;
        this.valueHeuristic = valueHeuristic;
        this.arcConsistency = new ArcConsistency(contraintes);
    }

    /*
    @Override
    public Map<Variable, Object> solve() 
    {
        Map<Variable, Set<Object>> domains = new HashMap<Variable, Set<Object>>();
        for (Variable var : this.variables) {
            domains.put(var, var.getDomain());
        }

        for(int i=0 ; i<domains.size() ; i++)
        {
            HashMap<Variable, Object> affectation = new HashMap<Variable, Object>();
            Variable v = this.variableHeuristic.best(domains.keySet(), domains);
            affectation.put(v, this.valueHeuristic.ordering(v, domains.get(v)));

            if(isConsistent(affectation))
                return affectation;

            domains.remove(v);
        }
        
        return null;
    }
    */

    public Map<Variable, Object> solve() 
    {
        Map<Variable, Set<Object>> ensDomaines = new HashMap<>();

        for(Variable v : this.variables)
            ensDomaines.put(v, v.getDomain());

        return macHeuristic(new HashMap<>(), new HashSet<>(this.variables), ensDomaines);
    }

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
