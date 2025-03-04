public class Main{
public static void main(String[] args) {
    int n=0;
    int k=0;
    try {
         Init conf = new Init(args);
         n = conf.getN();
         k = conf.getK();

         int[][] graphC = new int[n][n];

         int[][] graphD = {
                {0, 1, 0, 0, 0},
                {1, 0, 1, 0, 1},
                {0, 1, 0, 0, 1},
                {0, 0, 0, 0, 0},
                {0, 1, 1, 0, 0}
        };

        //System.out.println("N = " + n);

        //System.out.println("K = " + k);

        Build graph = new Build(n, k);

        graphC=graph.printGraph();

        Bonus bonus = new Bonus(graphC, k);

       /*
        Bonus bonusHard = new Bonus(graphD, 3);


        if(bonusHard.check())
            System.out.println("Graful contine o clica formata din " + k + " elemente");
        else
            System.out.println("Graful nu contine o clica formata din " + k + " elemente");
       */
        if(bonus.check())
            System.out.println("Graful contine o clica formata din " + k + " elemente");
        else
            System.out.println("Graful nu contine o clica formata din " + k + " elemente");

        if(bonus.stableSetCheck(graphC,k))
            System.out.println("Graful contine un set stabil format din " + k + " elemente");

    } catch (IllegalArgumentException e)
    {
        System.out.println(e.getMessage());
    }

}
}