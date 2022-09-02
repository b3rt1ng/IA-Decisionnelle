import representationtests.VariableTests;

public class Main {

public static void main(String[] args) {
    boolean ok = true ;
    ok = ok && VariableTests.testEquals();
    ok = ok && VariableTests.testHashCode();
    System.out.println(ok ? " All tests OK " : " At least one test KO ");
}

}