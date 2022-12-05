package blocksworld.representation;

import java.util.HashSet;
import java.util.Set;
import java.util.HashMap;
import java.util.Map;

import representation.BooleanVariable;
import representation.Variable;

public class WorldOfBooleanVariables extends World {

    protected Map<Integer, BooleanVariable> booleanOnB;

    public WorldOfBooleanVariables(int nbBlocks, int nbStacks) {
        super(nbBlocks, nbStacks);

        this.booleanOnB = new HashMap<>();

        for (int i = 0; i < nbBlocks; i++) {
            for (int j = -nbStacks; j < nbBlocks; j++) {
                if (i != j) {
                    if (j < 0) {
                        BooleanVariable var = new BooleanVariable("onB(" + i + " P " + j + ")");
                        this.booleanOnB.put(i * nbBlocks + j, var);
                    } else {
                        BooleanVariable var = new BooleanVariable("onB(" + i + " B " + j + ")");
                        this.booleanOnB.put(i * nbBlocks + j, var);
                    }
                }
            }
        }
    }

    public Set<BooleanVariable> getBooleanVariables() {
        Set<BooleanVariable> variables = new HashSet<>();
        variables.addAll(this.fixedB.values());
        variables.addAll(this.freeP.values());
        variables.addAll(this.booleanOnB.values());
        return variables;
    }

    public Map<Integer ,BooleanVariable> getBooleanOnB() {
        return this.booleanOnB;
    }

    @Override
    public String toString() {
        String s = "WorldOfBooleanVariables [nbBlocks=" + nbBlocks + ", nbStacks=" + nbStacks + ", onB=" + onB + ", freeP="
                + freeP + "]";
        return s;
    }
}
