package representation;

import java.util.*;

/**
 * Class representing a variable.
 * 
 * @author Kenzo LECOINDRE
 */
public class Variable
{
    /**
     * The name of the variable.
     */
    protected String name;

    /**
     * The domain of the variable.
     */
    protected Set<Object> domain;

    /**
     * Initialise a new Variable given a name and a domain.
     *
     * @param name A String object representing a name.
     * @param domain A Set of objects representing a the domain that this variable is based on.
     * 
     */
    public Variable(String name, Set<Object> domain)
    {
        this.name = name;
        this.domain = domain;
    }

    /**
     * The getName function returns the name of the variable.
     *
     * 
     * @return The name of the variable.
     * 
     */
    public String getName() { return this.name; }


    /**
     * The getDomain function returns the domain of the variable.
     *
     * 
     * @return The domain of the variable.
     * 
     */
    public Set<Object> getDomain() { return this.domain; }

    /**
     * The equals function is used to determine if two variables are equal.
     *
     * 
     * @param o Used to Compare the object to this.
     * @return True if the name of both variables are equal.
     * 
     */
    @Override
    public boolean equals(Object o)
    {
        try
        {
            Variable v = (Variable)o;

            if(v.getName().equals(this.name))
                return true;
        }
        catch(Exception e) {}

        return false;
    }

    /**
     * The hashCode function returns a hash code value for the variable based on the name of the variable. 
     * 
     * </br>
     * 
     * This method is supported for the benefit of hash tables such as those provided by HashMap.
     * The general contract of hashCode is: Whenever it is invoked on the same object more than once during an execution of a Java application, the {
     * 
     * @return The hash code of the name field.
     * 
     */
    @Override
    public int hashCode()
    {
        return this.name.hashCode();
    }

    /**
     * The toString function returns a string representation of the object.
     * This is useful for debugging purposes, and can be used to print out an
     * object or part of an object.  The function returns a String that contains
     * the name of the variable.
     * 
    * @return A String representation of the variable.
    * 
    */
    @Override
    public String toString()
    {
        return this.name;
    }
}