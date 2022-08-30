package representation;

import java.util.*;

public class Variable
{
    private String name;
    private Set<Object> domaine;

    public Variable(String name, Set<Object> domaine)
    {
        this.name = name;
        this.domaine = domaine;
    }

    public String getName() { return this.name; }
    public Set<Object> getDomaine() { return this.domaine; }

    @Override
    public boolean equals(Object o)
    {
        Variable v = (Variable)o;

        if(v.getName().equals(this.name))
            return true;
        return false;
    }

    //Attention taille int
    
    public int hashcode()
    {
        if(this.name == null)
            return 0;
        
        int hash = 0;
        for(int i=1 ; i<= this.name.length() ; i++)
            hash += Math.pow((int)(this.name.charAt(i-1)), i);
        
        return hash;
    }

    @Override
    public String toString()
    {
        String res = this.name + " :";
        res += "\n" + "hashcode:" + this.hashcode();

        return res;
    }
}