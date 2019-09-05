import java.util.ArrayList;

public class main {
    static int inf = 9999;

    public static void main(String[] args){

        int[][] A = {
                {inf, 3, 8, 4, inf, 10},
                {3, inf, inf, 6, inf, inf},
                {8, inf, inf, inf, 7, inf},
                {4, 6, inf, inf, 1, 3},
                {inf, inf, 7, 1, inf, 1},
                {10, inf, inf, 3, 1, inf}
        };


        System.out.println("--==Grafo==--");
        imprimirMatriz(A);
        System.out.println("----");
        int x = 0;
        int y = 5;
        menorCaminho(A, x, y);


        int n = A.length;
        System.out.println("--==Outros caminhos de teste==--");
        for (int i = 0; i < n; i++){
            for (int j = i + 1; j < n; j++){
                menorCaminho(A,i,j);
            }
        }


    }

    private static void imprimirArray(int[] a){
        String m;
        for (int v : a){
            m = (v == inf ? "inf" : String.valueOf(v));
            System.out.print(m + " ");
        }
        System.out.println();
    }

    private static void imprimirMatriz(int[][] A){
        for (int[] a : A){
            imprimirArray(a);
        }
    }

    private static void menorCaminho(int[][] A, int x, int y){

        int n = A.length;
        ArrayList<Integer> IN = new ArrayList<Integer>();

        int[] d = new int[n];
        int[] s = new int[n];

        for (int i = 0; i < n; i++) {
            d[i] = inf;
            s[i] = inf;
        }
        d[x] = 0;

        int distAnterior = inf;

        for (int z = 0; z < n; z++){
            if (z != x){
                d[z] = A[x][z];
                s[z] = x;
            }
        }

//        #   processa os vértices de IN
        while (IN.contains(y) == false){
            int p = -1;
            int minD = inf;
            for (int z = 0; z < n; z++){
                if (IN.contains(z) == false){
                    if (minD > d[z]){
                        minD = d[z];
                        p = z;
                    }
                }
            }
            IN.add(p);
            for (int z = 0; z < n; z++){
                if(IN.contains(z) == false){
                    distAnterior = d[z];
                    d[z] = Math.min(d[z], d[p] + A[p][z]);
                    s[z] = (d[z] != distAnterior) ? p : s[z];
                }
            }
        }



        ArrayList<Integer> caminho = new ArrayList<Integer>();
        caminho.add(y);
        int z = y;
        while (z != x){
            z = s[z];
            caminho.add(0, z);
        }
        System.out.print("Menor caminho entre " + x + " e " + y + " : ");
        System.out.println(caminho);

    }


}
