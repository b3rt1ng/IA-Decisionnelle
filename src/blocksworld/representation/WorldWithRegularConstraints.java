package blocksworld.representation;

import java.util.HashSet;
import java.util.Set;

import representation.Implication;
import representation.Variable;
import representation.Constraint;

/**
 * Class representing a state of the blocks world with regular constraints.
 * 
 * @author Antoine Collenot, Kenzo Lecoindre
 */
public class WorldWithRegularConstraints extends WorldWithConstraint {

    protected Set<Constraint> regularConstraints;

    /**
     * Idomtialise a new World given the number of blocks and the number of stacks.
     * 
     * @param nbBlocks the number of blocks in the world.
     * @param nbStacks the number of stacks in the world.
     */
    public WorldWithRegularConstraints(int nbBlocks, int nbStacks) {
        super(nbBlocks, nbStacks);

        this.regularConstraints = new HashSet<>();

        Set<Integer> ensDom = new HashSet<>();

        for (Integer val : this.freeP.keySet()) {
            ensDom.add(val);
        }

        for(Integer i : this.onB.keySet()) {
            Variable varA = this.onB.get(i);

            for (Object obj: varA.getDomain()){
                Integer dom = (Integer) obj;

                Integer mustBe = dom + (dom - i);

                if (dom >= 0) {
                    Variable varB = this.onB.get(dom);
                    Set<Object> newDom = new HashSet<>(ensDom);
                    if (mustBe >= 0 && mustBe < this.nbBlocks) {
                        newDom.add(mustBe);
                    }

                    Set<Object> firstDom = Set.of(dom);

                    this.regularConstraints.add(new Implication(varA, firstDom, varB, newDom));
                }
            }
        }
    }

    /**
     * @return the regularConstraints
     */
    public Set<Constraint> getRegularConstraints() {
        return this.regularConstraints;
    }

    @Override
    public String toString() {
        String str = "WorldWithRegularConstraints [onB=" + this.onB + ", fixedB=" + this.fixedB + ", freeP=" + this.freeP + ", nbBlocks=" + this.nbBlocks + ", nbStacks=" + this.nbStacks + ", regularConstraints=" + this.regularConstraints + "]";
        return str;
    }
}
