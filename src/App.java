import java.util.ArrayList;
import java.util.Collections;

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
        for (int i = 0; i < negativeS.length ; i++) {
            negativeS[i] = "buy Amazon";
        }

        // Resultado:
        System.out.println(hasTrend(negativeS, S_line));

        //Problema 2 : Multiplicação de matrizes utilizando divisão e conquista

        // Algoritmo comum de multiplicação de matrizes O(n^3)
        int[][] A = new int[2][2];

        for(int i = 0; i < A.length; i++){
            for(int j = 0; j < A[i].length; j++){
                A[i][j] = 2;
            }
        }

        int[][] B = new int[2][2];

        for(int i = 0; i < B.length; i++){
            for(int j = 0; j < B[i].length; j++){
                B[i][j] = 1;
            }
        }

        int[][] resultado = new int[A[0].length][B[0].length];
        multiply(A,B, resultado);

        for (int i = 0; i < resultado.length; i++) {
            for (int j = 0; j < resultado[i].length; j++) {
                System.out.printf("%d \n", resultado[i][j]);
            }
        }

        //Algoritmo de Strassen’s (division and conquer)
    }

    public static boolean hasTrend(String[] S, String[] S_line){

        ArrayList<String> newS = new ArrayList<>();
        Collections.addAll(newS, S);
        int countIguais = 0; 

        for (int i = 0; i < S_line.length; i++){
            for (int j = 0; j < S_line.length; j++) {
                if(S[i].equals(S_line[j])){
                    countIguais++;
                }    
            }            
        }

        if((countIguais == S_line.length)){
            return true;
        }else{
            for (int i = 0; i < newS.size(); i++) {
                for (int j = i+1; j < newS.size(); j++) {
                    if(newS.get(i).equals(newS.get(j))){
                        newS.remove(j);
                        System.out.println(newS.get(j));
                        newS.toArray(S);
                        hasTrend(S, S_line);
                    }else{
                        break;
                    }                
                }
            }
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
