package blocksworld.representation;

import java.util.HashSet;
import java.util.Set;

import blocksworld.datamining.Tuple;

import java.util.HashMap;
import java.util.Map;
import java.util.List;

import representation.BooleanVariable;
import representation.Variable;

/**
 * Class representing a state of the blocks world that adapt it's onB to boolean variables.
 * 
 * @author Antoine Collenot, Kenzo Lecoindre
 */
public class WorldOfBooleanVariables extends World {

    /**
     * The onB booleanized
     */
    protected Map<Tuple, BooleanVariable> booleanOnB;

    /**
     * Constructor of the class WorldOfBooleanVariables
     * 
     * @param nbBlocks the number of blocks in the world.
     * @param nbStacks the number of stacks in the world.
     */
    public WorldOfBooleanVariables(int nbBlocks, int nbStacks) {
        super(nbBlocks, nbStacks);

        this.booleanOnB = new HashMap<>();

        for (int i = 0; i < nbBlocks; i++) {
            for (int j = -nbStacks; j < nbBlocks; j++) {
                if (i != j) {
                    if (j < 0) {
                        this.booleanOnB.put(new Tuple(i, j), new BooleanVariable("onG(" + i + " P " + j + ")"));
                    } else {
                        this.booleanOnB.put(new Tuple(i, j), new BooleanVariable("onB(" + i + " P " + j + ")"));
                    }
                }
            }
        }
    }


    /**
     * process a worlds to get it's boolean variables
     * 
     * @param state a world state
     * @param nbBlocks the number of blocks in the world.
     * @param nbStacks the number of stacks in the world.
     * 
     * @return a world of boolean variables
     */
    public Set<BooleanVariable> processState(List<List<Integer>> state, int nbBlocks, int nbStacks) {
        Set<BooleanVariable> instance = new HashSet<>();
        WorldOfBooleanVariables world = new WorldOfBooleanVariables(nbBlocks, nbStacks);

        for (int i = 0; i < state.size(); i++) {
            if (state.get(i).isEmpty()) {
                instance.add(world.getFreeP().get(-(i+1)));
            } else {
                BooleanVariable block = world.getBooleanOnB().get(new Tuple(state.get(i).get(0), -(i+1)));
                instance.add(block);
                if (state.get(i).size() > 1) {
                    instance.add(world.getFixedB().get(state.get(i).get(0)));
                    for (int j = 1; j < state.get(i).size(); j++) {
                        instance.add(world.getBooleanOnB().get(new Tuple(state.get(i).get(j), state.get(i).get(j-1))));
                        if (j < state.get(i).size() - 1) {
                            instance.add(world.getFixedB().get(state.get(i).get(j)));
                        }
                    }
                }
            }
        }
        return instance;
    }

    /**
     * Getter for all the boolean variables of the current world
     * 
     * @return the set of all the boolean variables of the current world
     */
    public Set<BooleanVariable> getBooleanVariables() {
        Set<BooleanVariable> variables = new HashSet<>();
        variables.addAll(this.fixedB.values());
        variables.addAll(this.freeP.values());
        variables.addAll(this.booleanOnB.values());
        return variables;
    }

    /**
     * Getter for the booleanOnB
     * 
     * @return the booleanOnB
     */
    public Map<Tuple ,BooleanVariable> getBooleanOnB() {
        return this.booleanOnB;
    }

    @Override
    public String toString() {
        String s = "WorldOfBooleanVariables [nbBlocks=" + nbBlocks + ", nbStacks=" + nbStacks + ", onB=" + onB + ", freeP="
                + freeP + "]";
        return s;
    }
}