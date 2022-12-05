package blocksworld.datamining;

import java.util.List;
import java.util.Random;
import java.util.Set;

import bwgeneratordemo.Demo;
import datamining.BooleanDatabase;
import representation.BooleanVariable;
import blocksworld.representation.WorldWithRegularConstraints;

public class DataminingOnBlockWorld {
    
    protected int nbBlocks;
    protected int nbStacks;

    protected List<List<Integer>> state;

    public DataminingOnBlockWorld(int nbBlocks, int nbStacks) {

        WorldWithRegularConstraints world = new WorldWithRegularConstraints(nbBlocks, nbStacks);
        this.nbBlocks = nbBlocks;
        this.nbStacks = nbStacks;

        // BooleanDatabase db = new BooleanDatabase(world.getFixedB());
        for (int i = 0; i < 100; i++) {
            List<List<Integer>> state = Demo.getState(new Random());
            // Set<BooleanVariable> instance = Demo.getInstance(state);
            // db.add(instance);
        }
    }


}