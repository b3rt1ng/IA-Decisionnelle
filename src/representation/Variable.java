package representation;

import java.util.*;

public class Variable
{
    protected String name;
    protected Set<Object> domaine;

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

    @Override
    public int hashCode()
    {
        return this.name.hashCode();
    }

    @Override
    public String toString()
    {
        String res = this.name + " :";
        res += "\n" + "hashcode:" + this.hashCode();

        return res;
    }
}