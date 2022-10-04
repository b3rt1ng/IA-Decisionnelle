package representation;

import java.util.*;

/**
 * Classe représentant une variable.
 * 
 * @author Kenzo LECOINDRE
 */
public class Variable
{
    protected String name;
    protected Set<Object> domain;

    /**
     * Constructor that construct a new Variable.
     *
     * 
     * @param o Used to Compare the object to this.
     * @return True if the name of both variables are equal.
     * 
     */
    public Variable(String name, Set<Object> domain)
    {
        this.name = name;
        this.domain = domain;
    }

    /**
     * The getName function returns the name of this object.
     *
     * 
     * @return The name of the person.
     * 
     */
    public String getName() { return this.name; }


    /**
     * The getDomain function returns the domain of the function.
     *
     * 
     * @return The domain of the function.
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
        Variable v = (Variable)o;

        if(v.getName().equals(this.name))
            return true;
        return false;
    }

    /**
     * The hashCode function returns a hash code value for the object. This method is supported for the benefit of hash tables such as those provided by HashMap.
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
     * the name of the class (e.g., "Person"), followed by a colon, then followed by
     * all fields in this class separated by commas and ending with a semicolon.  For example:<br> <code>Person:name=John;age=25</code><br> Note that this function does not return any information about other classes that may be related to this one via inheritance.<br><p/>This function is called automatically when you print out an Object using System.out's println method.<p/>For more information on what each field represents, see Person's JavaDoc comments above its declaration in Person2_3_4_5_6.</p></td></tr></table>

        public static void main(String[] args) {

            // Create some objects from our new class:

            Person p = new Person("John", 25); // Calls constructor for us!

            System.out.println(p); // Prints it out! (See toString() above
    * 
    * @return The name of the object.
    * 
    */
    @Override
    public String toString()
    {
        String res = this.name + " :";
        res += "\n" + "hashcode:" + this.hashCode();

        return res;
    }
}