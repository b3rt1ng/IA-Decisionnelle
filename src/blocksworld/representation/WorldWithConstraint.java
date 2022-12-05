package blocksworld.representation;

import java.util.Set;
import java.util.HashSet;

import representation.Variable;
import representation.Constraint;
import representation.DifferenceConstraint;
import representation.Implication;


/**
 * Class representing a state of the blocks world.
 * 
 * @author Antoine Collenot
 */
public class WorldWithConstraint extends World {

    /**
     * a set of difference constraints applicable to our blocks to ensure that a block with a given value cannot take the same value as another different block.
     */
    protected Set<Constraint> differenceConstraints;

    /**
     * a set of implcation constraints applicable to our blocks
     */
    protected Set<Constraint> implicationConstraints;

    /**
     * Initialise a new World given the number of blocks and the number of stacks.
     * 
     * @param nbBlocks the number of blocks in the world.
     * @param nbStacks the number of stacks in the world.
     */
    public WorldWithConstraint(int nbBlocks, int nbStacks) {
        super(nbBlocks, nbStacks);

        this.differenceConstraints = new HashSet<>();
        this.implicationConstraints = new HashSet<>();

        // Initialisation of the constraints stating that a block value cannot take the same value as another block
        for (int i = 0; i < nbBlocks; i++) {
            for (int j = 0; j < nbBlocks; j++) {
                this.differenceConstraints.add(new DifferenceConstraint(this.onB.get(i), this.onB.get(j)));
            }
        }

        for (Variable onBlock : this.onB.values()) {
            for (Object value : onBlock.getDomain()) {
                Integer i = (Integer) value;
                Set<Object> s1 = Set.of(i);
                Set<Object> s2 = new HashSet<>(0);
                Variable v;
                if (i < 0) {
                    v = this.freeP.get(i);
                    s2.add(false);
                } else {
                    v = this.onB.get(i);
                    s2.add(true);
                }
                this.implicationConstraints.add(new Implication(onBlock, s1, v, s2));
            }
        }
    }

    /**
     * @return the constraints
     */
    public Set<Constraint> getConstraints() {
        Set<Constraint> result = new HashSet<>();
        result.addAll(this.implicationConstraints);
        result.addAll(this.differenceConstraints);
        return result;
    }
}
