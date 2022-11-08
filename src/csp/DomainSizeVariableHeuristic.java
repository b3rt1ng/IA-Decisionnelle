package csp;

import java.util.Map;
import java.util.Set;

import representation.Variable;

/**
 * Class representing a "domain size variable heuristic".
 * 
 * @author Antoine Collenot, Kenzo Lecoindre
 */
public class DomainSizeVariableHeuristic implements VariableHeuristic
{
    /**
     * A boolean that tells us if we prefer the variables with the bigest or the smallest domain.
     */
    private boolean moreDomainSize;

    /**
     * Constructor for the DomainSizeVariableHeuristic class.
     * 
     * @param moreDomainSize A boolean that tells us if we prefer the variables with the bigest or the smallest domain.
     */
    public DomainSizeVariableHeuristic(boolean moreDomainSize)
    {
        this.moreDomainSize = moreDomainSize;
    }

    @Override
    public Variable best(Set<Variable> vars, Map<Variable, Set<Object>> domains) 
    {
        Variable best = null;
        int bestDomainSize = 0;
        
        for(Variable v : vars)
        {
            if(best == null || (moreDomainSize && domains.get(v).size() > bestDomainSize) || (!moreDomainSize && domains.get(v).size() < bestDomainSize))
            {
                best = v;
                bestDomainSize = domains.get(v).size();
            }
        }
        
        return best;
    }
    
}
