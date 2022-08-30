package representation;

public class DifferenceConstraint implements Constraint {

    Variable v1;
    Variable v2;

    public DifferenceConstraint(Variable v1, Variable v2){
        if (v1.equals(v2)) {
            throw new IllegalArgumentException("la variavle v1 est la même que la variable v2");
        } else {
            this.v1 = v1;
            this.v2 = v2;
        }
    }

}