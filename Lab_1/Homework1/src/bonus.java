import java.lang.reflect.Array;

public class bonus {
    private int[][] graph;

    private int k;
    private int n;

    public bonus(int[][] graph, int k) {
        this.graph = graph;
        this.k = k;
        this.n = graph.length;
    }

    public boolean check() {
        //System.out.println("Am ajuns in clasa bonus");
        int[] attempt = new int[this.k];

        for (int i = 0; i < this.k; i++)
            attempt[i] = i;

        while (attempt != null) {
            if (isClique(graph, attempt))
                return true;
            else {
                System.out.println(java.util.Arrays.toString(attempt));
                attempt = nextAttempt(attempt, this.n);
            }
        }
        System.out.println("Returnam false");
        return false;
    }

    private boolean isClique(int[][] graph, int[] attempt) {
        //System.out.println("Am ajuns in isClique");
        for (int i = 0; i < attempt.length; i++) {
            for (int j = i + 1; j < attempt.length; j++) {
              //  System.out.println("Testam:" + i + " si " + j);
                if (graph[attempt[i]][attempt[j]] == 0) {

                    //System.out.println("Clica a dat fail din cauaza nodului: " + i + " si " + j);
                    return false;
                }
            }
        }
       // System.out.println("Clica valida");
        return true;
    }

    private int[] nextAttempt(int[] attempt, int n) {
        for (int i = k - 1; i >= 0; i--) {
            if (attempt[i] < n - k + i) {
                attempt[i]++;

                for (int j = i + 1; j < k; j++) {
                    attempt[j] = attempt[j - 1] + 1;
                }
                return attempt;
            }
        }

        return null;
    }


    public boolean stableSetCheck(int[][] graph, int k)
    {
        int n = graph.length;
        int[][] complGraph = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    complGraph[i][j] = 0;
                } else {
                    complGraph[i][j] = (graph[i][j] == 0) ? 1 : 0;
                }
            }
        }
        for(int i=0;i<n;i++) {
            for (int j = 0; j < n; j++)
              System.out.print(complGraph[i][j] + " ");
              System.out.println("");
        }
        this.graph=complGraph;
        this.k=k;
        this.n=graph.length;
        return check();
    }


}
