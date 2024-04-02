public class App {
    public static void main(String[] args) throws Exception {
        /*
            Trabalho 1 - Projeto e Otimização de algoritmos
            Leonardo Heinen Oliveira e Leonardo Vargas Soares
            Turma 31 - Professor Rafael Scopel
        */

        // Problema 1: HasTrend (greedy algorithm)
        // Caso de retorno positivo
        // Carga de dados: 
        String[] S = new String[10];
        S[0] = "buy Google";
        S[1] = "buy Apple";
        S[2] = "buy Apple";
        S[3] = "buy Apple";
        S[4] = "buy Apple";
        S[5] = "buy Google";
        S[6] = "buy Google";
        S[7] = "buy Google";
        S[8] = "buy NVIDIA";
        S[9] = "buy NVIDIA";

        String[] S_line = new String[4];
        S_line[0] = "buy Google";
        S_line[1] = "buy Apple";
        S_line[2] = "buy Google";
        S_line[3] = "buy NVIDIA";

        // Resultado:
        System.out.println(hasTrend(S, S_line));

        // Caso de retorno negativo
        // Carga de dados: 
        String[] negativeS = new String[10];
        negativeS[0] = "buy Amazon";
        negativeS[1] = "buy Amazon";
        negativeS[2] = "buy Amazon";
        negativeS[3] = "buy Amazon";
        negativeS[4] = "buy Amazon";
        negativeS[5] = "buy Amazon";
        negativeS[6] = "buy Amazon";
        negativeS[7] = "buy Amazon";
        negativeS[8] = "buy Amazon";
        negativeS[9] = "buy Amazon";

        String[] negativeS_line = new String[4];
        negativeS_line[0] = "buy Google";
        negativeS_line[1] = "buy Apple";
        negativeS_line[2] = "buy Google";
        negativeS_line[3] = "buy NVIDIA";
        // Resultado:
        System.out.println(hasTrend(negativeS, negativeS_line));

        //Problema 2 : Algoritmo de Strassen’s (division and conquer)

    }

    public static boolean hasTrend(String[] S, String[] S_line){
        for (int i = 0; i < S.length; i++){
            S[i] = "0";
            return true;
        }
        return false;
    }

    public int[][] multiply(int[][] A, int[][] B){ // Algoritmo de Strassen’s, divisão e conquista
        int size = A.length;

        if (size == 1)
        {
            int[][] C = new int[1][1];
            C[0][0] = A[0][0] * B[0][0];
            return C;
        }
        else
        {
            int[][] retorno = new int[A[0].length][B.length];
            return retorno;
        }
    }

    static void multiply(int A[][], int B[][], int resultado[][]){ // Algoritmo normal de multiplicação de matrizes, O(n^3)
        int N = A[0].length;
        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < N; j++)
            {
                resultado[i][j] = 0;
                for (int k = 0; k < N; k++)
                {
                    resultado[i][j] += A[i][k]*B[k][j];
                }
            }
        }
    }
}
