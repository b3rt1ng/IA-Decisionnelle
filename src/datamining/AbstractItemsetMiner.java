package datamining;

import java.util.Comparator;
import java.util.Set;

import representation.BooleanVariable;

public abstract class AbstractItemsetMiner implements ItemsetMiner {

    protected BooleanDatabase base;
    
    public AbstractItemsetMiner(BooleanDatabase base) {
        this.base = base;
    }

    public float frequency(Set<BooleanVariable> items) {
        float result = 0;
        for (Set<BooleanVariable> transaction : this.base.getTransactions()) {
            if (transaction.containsAll(items)) {
                result++;
            }
        }
        return result / this.base.getTransactions().size();
    }

    public static final Comparator<BooleanVariable> COMPARATOR = (var1, var2) -> var1.getName().compareTo(var2.getName());

    public BooleanDatabase getDatabase() {
        return this.base;
    }

}
