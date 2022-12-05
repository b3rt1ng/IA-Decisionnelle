package blocksworld.representation;

import representation.Constraint;

public class Test {
    public static void main(String[] args) {
        WorldWithRegularConstraints wwrc = new WorldWithRegularConstraints(6, 2);

        for (Constraint c : wwrc.getConstraints())
            System.out.println(c.getScope());

    }
}
