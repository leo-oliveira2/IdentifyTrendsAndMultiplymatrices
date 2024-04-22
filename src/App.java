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
        // System.out.println(hasTrend(S, S_line));

        // Caso de retorno negativo
        // Carga de dados: 
        String[] negativeS = new String[10];
        for (int i = 0; i < negativeS.length ; i++) {
            negativeS[i] = "buy Amazon";
        }

        // Resultado:
        // System.out.println(hasTrend(negativeS, S_line));

        // Teste temporal: 

        // Conjunto de Dados Pequeno
        // String[] subsequenciaPequena = {"Google", "Amazon", "Google"};
        // String[] serieTemporalPequena = {"Google", "Amazon", "Amazon", "Amazon", "Amazon", "Google", "Google", "Google"};
        // hasTrend(serieTemporalPequena, subsequenciaPequena);

        // Conjunto de Dados Médio
        // String[] subsequenciaMedio = {"Google", "Amazon", "Google"};
        // String[] serieTemporalMedio = {"Google", "Apple", "Apple", "Apple", "Apple", "Google", "Google", "Google", "NVIDIA", "NVIDIA", "NVIDIA", "Microsoft", "Microsoft", "Microsoft", "Microsoft", "Facebook", "Facebook", "Facebook", "Amazon", "Amazon", "Amazon", "Amazon", "Tesla", "Tesla", "Tesla", "Tesla", "Sony", "Sony", "Sony", "Sony", "Google", "Amazon", "Google", "Google", "Apple", "Apple", "Apple", "Apple", "Google", "Google", "Google", "NVIDIA", "NVIDIA", "NVIDIA", "Microsoft", "Microsoft", "Microsoft", "Microsoft", "Facebook", "Facebook", "Facebook", "Amazon", "Amazon", "Amazon", "Amazon", "Tesla", "Tesla", "Tesla", "Tesla", "Sony", "Sony", "Sony", "Sony", "Google", "Amazon", "Google", "Google", "Apple", "Apple", "Apple", "Apple", "Google", "Google", "Google", "NVIDIA", "NVIDIA", "NVIDIA", "Microsoft", "Microsoft", "Microsoft", "Microsoft", "Facebook", "Facebook", "Facebook", "Amazon", "Amazon", "Amazon", "Amazon", "Tesla", "Tesla", "Tesla", "Tesla", "Sony", "Sony", "Sony", "Sony"};
        // hasTrend(serieTemporalMedio, subsequenciaMedio);

        // Conjunto de Dados Grande
        String[] subsequenciaGrande = {"Google", "Amazon", "Google"};
        String[] serieTemporalGrande = new String[10000];

        // Preencher a série temporal grande com padrões repetidos
        for (int i = 0; i < 10000; i++) {
            if (i % 4 == 0) {
                serieTemporalGrande[i] = "Google";
            } else if (i % 4 == 1 || i % 4 == 2) {
                serieTemporalGrande[i] = "Apple";
            } else {
                serieTemporalGrande[i] = "Amazon";
            }
        }


        hasTrend(serieTemporalGrande, subsequenciaGrande);


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

        // for (int i = 0; i < resultado.length; i++) {
        //     for (int j = 0; j < resultado[i].length; j++) {
        //         System.out.printf("%d \n", resultado[i][j]);
        //     }
        // }

        //Algoritmo de Strassen’s (division and conquer)
    }

    public static boolean hasTrend(String[] S, String[] S_line) {
        // Medindo o tempo do ínicio do algoritmo
        long start = System.currentTimeMillis();
        ArrayList<String> newS = new ArrayList<>();
        ArrayList<String> newS_line = new ArrayList<>();
        Collections.addAll(newS, S);
        Collections.addAll(newS_line, S_line);
        int indexS = 0; // Índice para percorrer a lista original S

        // Percorre a lista de subsequência reduzida
        for (String s : newS_line) {
            boolean found = false; // Flag para indicar se a string da subsequência foi encontrada

            // Percorre a lista original S a partir do índice atual
            for (int i = indexS; i < newS.size(); i++) {
                if (newS.get(i).equals(s)) { // Se encontrar a string na lista original
                    found = true;
                    indexS = i + 1; // Atualiza o índice para começar a próxima busca após esta posição
                    break;
                }
            }

            // Se a string da subsequência não foi encontrada na lista original, retorna falso
            if (!found) {
                long elapsed = System.currentTimeMillis() - start;

                System.out.printf("%.3f ms%n", (elapsed - start) / 1000d);
        
                return false;
                
            }
        }

        
        //Medindo o tempo final
        long elapsed = System.currentTimeMillis() - start;
        System.out.printf("Executado em %.3f ms%n", (elapsed - start) / 1000d);
        System.out.println(elapsed);
        // Se percorreu toda a lista de subsequência reduzida e encontrou todas as strings na lista original
        // então retorna verdadeiro
        return true;
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
