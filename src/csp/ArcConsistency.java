package csp;

import java.util.Map;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import representation.Constraint;
import representation.Variable;

/**
 * Class representing an arc consistency.
 * 
 * @author Antoine Collenot, Kenzo Lecoindre
 */
public class ArcConsistency 
{
    /**
     * A set of variables.
     */
    private Set<Constraint> ensConstraints;

    public ArcConsistency(Set<Constraint> ensConstraints)
    {
        for(Constraint constraint : ensConstraints)
        {
            Set<Variable> scope = constraint.getScope();
            if(scope.size() < 1 || scope.size() > 2)
            {
                throw new IllegalArgumentException(" L'une des contraintes n'est ni unaire ni binaire. ");
            }
        }
        this.ensConstraints = ensConstraints;
    }

    
    /** 
     * Method that removes the values ​​v of the domains for which there is an unsatisfied unary constraint unsatified by v.
     * 
     * @param ensDomaines a set of domains.
     * @return false if one domain has been empited, true otherwise.
     */
    public boolean enforceNodeConsistency(Map<Variable, Set<Object>> ensDomaines)
    {
        boolean bool = true;

        for(Variable var : ensDomaines.keySet())
        {
            HashSet<Object> domainToDelete = new HashSet<>();
            for(Object o : ensDomaines.get(var))
            {
                Map<Variable, Object> domain = new HashMap<>();
                domain.put(var, o);
                
                for(Constraint c : this.ensConstraints)
                    if(c.getScope().size() == 1 && c.getScope().contains(var) && !c.isSatisfiedBy(domain))
                        domainToDelete.add(o);
            }

            ensDomaines.get(var).removeAll(domainToDelete);
            if(ensDomaines.get(var).isEmpty())
                bool = false;
        }

        return bool;
    }

    
    /** 
     * Method that removes the values ​​v1 in d1 wich there's no such v2 in d2 supporting v1 for all constraints on v1 and v2.
     * 
     * @param v1 a variable.
     * @param d1 v1's domain.
     * @param v2 a variable.
     * @param d2 v2's domain.
     * @return true if at least one value has been removed from d1, false otherwise.
     */
    public boolean revise(Variable v1, Set<Object> d1, Variable v2, Set<Object> d2)
    {
        boolean del = false;
        Set<Object> ensSuppr = new HashSet<>();

        for(Object vi : d1)
        {
            boolean viable = false;
            for(Object vj : d2)
            {
                boolean toutSatisfait = true;
                for(Constraint c : this.ensConstraints)
                {
                    Set<Variable> scope = c.getScope();
                    if(scope.size() == 2 && scope.contains(v1) && scope.contains(v2)) 
                    {
                        HashMap<Variable, Object> n = new HashMap<>();
                        n.put(v1, vi);
                        n.put(v2, vj);
                        if(!c.isSatisfiedBy(n))
                        {
                            toutSatisfait = false;
                            break;
                        }
                    }
                }
                if(toutSatisfait)
                {
                    viable = true;
                    break;
                }
            }
            if(!viable)
            {
                ensSuppr.add(vi);
                del = true;
            }
        }
        d1.removeAll(ensSuppr);

        return del;
    }
    
    
    /** 
     * Filters all domains using ac1, until stable
     * 
     * @param ensDomaines a set of domains.
     * @return false if one domain has been empited, true otherwise.
     */
    public boolean ac1(Map<Variable, Set<Object>> ensDomaines)
    {
        if(!enforceNodeConsistency(ensDomaines))
            return false;

        boolean change;
        Set<Variable> ensKey = ensDomaines.keySet();
        do
        {
            change = false;
            for(Variable xi : ensKey)
            {
                for(Variable xj : ensKey)
                {
                    if(!(xi.equals(xj)) && revise(xi, ensDomaines.get(xi), xj, ensDomaines.get(xj)))
                        change = true;
                }
            }
        }
        while(change);

        for(Variable v : ensDomaines.keySet())
            if(ensDomaines.get(v).size() == 0)
                return false;

        return true;
    }

    @Override
    public String toString()
    {
        String res = "";

        for(Constraint c : this.ensConstraints)
            res += c.toString() + "\n";

        return res;
    }
}
