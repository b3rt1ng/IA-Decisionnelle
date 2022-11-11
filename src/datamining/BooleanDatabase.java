package datamining;

import java.util.List;
import java.util.Set;

import representation.BooleanVariable;

/**
 * Class representing a boolean database.
 * 
 * @author Antoine Collenot, Kenzo Lecoindre
 */
public class BooleanDatabase {

    /**
     * A set of Boolean Variable.
     */
    protected Set<BooleanVariable> items;

    /**
     * A list of transactions.
     */
    protected List<Set<BooleanVariable>> transactions;
    
    /**
     * Constructor for the BooleanDatabase class.
     * 
     * @param items A set of Boolean Variable.
     */
    public BooleanDatabase(Set<BooleanVariable> items) {
        this.items = items;
    }

    
    /** 
     * Adds a transaction to the database.
     * 
     * @param transaction A transaction.
     */
    public void add(Set<BooleanVariable> transaction) {
        this.transactions.add(transaction);
    }

    
    /** 
     * getter for the items.
     * 
     * @return The set of items contained in the database.
     */
    public Set<BooleanVariable> getItems() {
        return this.items;
    }
    
    
    /** 
     * getter for the transactions.
     * 
     * @return The list of transactions contained in the database.
     */
    public List<Set<BooleanVariable>> getTransactions() {
        return this.transactions;
    }

}
