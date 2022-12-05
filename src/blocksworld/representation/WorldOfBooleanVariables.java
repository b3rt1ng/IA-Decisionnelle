package blocksworld.representation;

import java.util.HashSet;
import java.util.Set;

import representation.BooleanVariable;
import representation.Variable;

public class WorldOfBooleanVariables extends World {

    public WorldOfBooleanVariables(int nbBlocks, int nbStacks) {
        super(nbBlocks, nbStacks);
    }

    protected void initBooleanVariables() {
        for (int i = 0; i < this.nbBlocks; i++) {
            this.onB.put(i, new BooleanVariable("onB" + i));
            this.freeP.put(i, new BooleanVariable("freeP" + i));
        }
    }

    public Set<BooleanVariable> getBooleanOnB() {
        Set<BooleanVariable> result = new HashSet<>();
        for (Variable v : super.getOnB().values())
            result.add((BooleanVariable) v);
        return result;
    }

    @Override
    public String toString() {
        String s = "WorldOfBooleanVariables [nbBlocks=" + nbBlocks + ", nbStacks=" + nbStacks + ", onB=" + onB + ", freeP="
                + freeP + "]";
        return s;
    }
}
