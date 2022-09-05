package representation;

import java.util.*;

public class Variable
{
    protected String name;
    protected Set<Object> domain;

    public Variable(String name, Set<Object> domain)
    {
        this.name = name;
        this.domain = domain;
    }

    public String getName() { return this.name; }
    public Set<Object> getDomain() { return this.domain; }

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