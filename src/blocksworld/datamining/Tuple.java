package blocksworld.datamining;

/**
 * A tuple is a representation of a set of two variable.
 */
public class Tuple {

    private int x;
    private int y;

    public Tuple(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Tuple) {
            Tuple t = (Tuple) obj;
            return this.x == t.getX() && this.y == t.getY();
        }
        return false;
    }

    @Override
    public String toString() {
        return "(" + this.x + "," + this.y + ")";
    }
}