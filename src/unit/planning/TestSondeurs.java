package unit.planning;

import unit.planning.TestBFSPlanner;
import planning.BFSPlanner;

public class TestSondeurs
{
    public static boolean allTests()
    {
        System.out.println("TestSondeurBFSPlanner : moyenne=" + TestSondeurs.testSondeurBFSPlanner());
        TestSondeurs.testSondeurDFSPlanner();
        TestSondeurs.testSondeurBFSPlanner();
        TestSondeurs.testSondeurDijkstraPlanner();
        TestSondeurs.testSondeurtestSondeurAStarPlanner();
        return true;
    }

    public static double testSondeurDFSPlanner()
    {
        int res = 0;
        return res;
    }

    public static double testSondeurBFSPlanner()
    {
        TestBFSPlanner.allTests();
        System.out.println();

        int res = 0;
        for(int i : BFSPlanner.ensNbNodes)
            res+=i;

        res = res/BFSPlanner.ensNbNodes.size();
        return res;
        
    }

    public static double testSondeurDijkstraPlanner()
    {
        int res = 0;
        return res;
    }

    public static double testSondeurAStarPlanner()
    {
        int res = 0;
        return res;
    }
}