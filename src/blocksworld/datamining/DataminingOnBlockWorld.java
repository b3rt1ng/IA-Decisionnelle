package blocksworld.datamining;

import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.HashSet;

import bwgeneratordemo.Demo;
import datamining.BooleanDatabase;
import representation.BooleanVariable;
import blocksworld.representation.WorldOfBooleanVariables;

public class DataminingOnBlockWorld {

    protected Random random = new Random();

    protected int nbTransaction = 10;

    public DataminingOnBlockWorld(int nbBlocks, int nbStacks) {

        System.out.println("starting datamining on " + nbBlocks + " blocks and " + nbStacks + " stacks with " + nbTransaction + " transactions");

        Set<BooleanVariable> items = new HashSet<>();

        WorldOfBooleanVariables world = new WorldOfBooleanVariables(nbBlocks, nbStacks);
        world.getBooleanVariables().forEach(v -> items.add(v));

        BooleanDatabase db = new BooleanDatabase(items);
        for (int i = 0; i < this.nbTransaction; i++) {
            List<List<Integer>> state = Demo.getState(this.random);
            // Set<BooleanVariable> instance = les états correspondants
            // db.add(instance);
        }
    }

    public static void main(String[] args) {
        DataminingOnBlockWorld dm = new DataminingOnBlockWorld(Demo.NB_BLOCKS, Demo.NB_STACKS);
    }
}