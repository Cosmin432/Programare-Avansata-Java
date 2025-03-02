import java.util.ArrayList;
import java.util.List;

public class build {
    private int n, k;
    private int[][] graph;


    public build(int n, int k) {
        this.n = n;
        this.k = k;
        this.graph = new int[n][n];

        generate();
    }

    private void generate() {
        List<Integer> clique = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            clique.add(i);
        }


        for (int i = 0; i < k; i++) {
            for (int j = i + 1; j < k; j++) {
                graph[i][j] = 1;
                graph[j][i] = 1;
            }

        }

        List<Integer> stable = new ArrayList<>();
        for (int i = k; i < 2 * k && i < n; i++) {
            stable.add(i);
        }
        stable.removeLast();


        compl(clique, stable);
    }

    private void compl(List<Integer> clique, List<Integer> stable) {
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (Math.random() < 0.5) {
                    if (valid(clique, stable, i, j)) {
                        graph[i][j] = 1;
                        graph[j][i] = 1;
                    }
                }
            }
        }
        System.out.println("Clique: " + clique);
        System.out.println("Stable: " + stable);
    }

    private boolean valid(List<Integer> clique, List<Integer> stable, int i, int j) {

        if (stable.contains(i) && stable.contains(j)) {
          //  System.out.println("1. Am oprit o muchie intre: " + i + " si " + j + " (set stabil)");
            return false;
        }


        if ((clique.contains(i) && stable.contains(j)) || (clique.contains(j) && stable.contains(i))) {
          //  System.out.println("2. Am oprit o muchie intre: " + i + " si " + j + " (clique -> stable)");
            return false;
        }


      //  System.out.println("3. Am permis o muchie intre: " + i + " si " + j);
        return true;
    }
    public int[][] printGraph() {
        String graphS="";
        int cnt=0;
        int cntDegree1=0;
        int cntDegree2=0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (graph[i][j]== 0) {
                    graphS = graphS + " ⬛ ";
                }else {
                    graphS = graphS + " ☕ ";
                    cnt++;
                    cntDegree1++;
                }

            }
           graphS = graphS + " \n";
           cntDegree2+=cntDegree1;
           cntDegree1=0;
        }
     System.out.println(graphS);
     System.out.println("Numarul de muchii este: " + cnt);
     System.out.println("Suma gradelor este: " + cntDegree2);
     if(cnt == cntDegree2)
         System.out.println("Nr de muchii este egal cu suma gradelor");
     return graph;
    }

    }
