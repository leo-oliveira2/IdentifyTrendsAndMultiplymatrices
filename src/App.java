import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

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

        // Teste temporal: 

        // Conjunto de Dados Pequeno
        String[] subsequenciaPequena = {"Google", "Amazon", "Google"};
        String[] serieTemporalPequena = {"Google", "Amazon", "Amazon", "Amazon", "Amazon", "Google", "Google", "Google"};
        hasTrend(serieTemporalPequena, subsequenciaPequena);

        // Conjunto de Dados Médio
        String[] subsequenciaMedio = {"Google", "Amazon", "Google"};
        String[] serieTemporalMedio = {"Google", "Apple", "Apple", "Apple", "Apple", "Google", "Google", "Google", "NVIDIA", "NVIDIA", "NVIDIA", "Microsoft", "Microsoft", "Microsoft", "Microsoft", "Facebook", "Facebook", "Facebook", "Amazon", "Amazon", "Amazon", "Amazon", "Tesla", "Tesla", "Tesla", "Tesla", "Sony", "Sony", "Sony", "Sony", "Google", "Amazon", "Google", "Google", "Apple", "Apple", "Apple", "Apple", "Google", "Google", "Google", "NVIDIA", "NVIDIA", "NVIDIA", "Microsoft", "Microsoft", "Microsoft", "Microsoft", "Facebook", "Facebook", "Facebook", "Amazon", "Amazon", "Amazon", "Amazon", "Tesla", "Tesla", "Tesla", "Tesla", "Sony", "Sony", "Sony", "Sony", "Google", "Amazon", "Google", "Google", "Apple", "Apple", "Apple", "Apple", "Google", "Google", "Google", "NVIDIA", "NVIDIA", "NVIDIA", "Microsoft", "Microsoft", "Microsoft", "Microsoft", "Facebook", "Facebook", "Facebook", "Amazon", "Amazon", "Amazon", "Amazon", "Tesla", "Tesla", "Tesla", "Tesla", "Sony", "Sony", "Sony", "Sony"};
        hasTrend(serieTemporalMedio, subsequenciaMedio);

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
        int linhas = 10000;
        int colunas = 10000;

        int[][] A = new int[linhas][colunas];
        int[][] B = new int[linhas][colunas];

        // Preencher as matrizes com dados aleatórios
        Random random = new Random();
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                A[i][j] = random.nextInt(100); // Números aleatórios de 0 a 99
                B[i][j] = random.nextInt(100);
            }
        }
        long start = System.currentTimeMillis();
        int[][] C = multiply(A, B);
        long end = System.currentTimeMillis();
        long elapsed = end - start;
        System.out.println("Executado em " + elapsed + " milisegundos");
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
                long end = System.currentTimeMillis();
                long elapsed = end - start;
                System.out.println("Executado em " + elapsed + "milisegundos");
        
                return false;
                
            }
        }

        
        //Medindo o tempo final
        long end = System.currentTimeMillis();
        long elapsed = end - start;
        System.out.println("Executado em " + elapsed + "milisegundos");
        // Se percorreu toda a lista de subsequência reduzida e encontrou todas as strings na lista original
        // então retorna verdadeiro
        return true;
    }

     public static int[][] multiply(int[][] A, int[][] B){
        int tamanho = A.length;

        // Caso base para a multiplicação (tamanho da matriz 1x1)
        if (tamanho == 1) {
            int[][] C = new int[1][1];
            C[0][0] = A[0][0] * B[0][0];
            return C;
        }

        // Dividir as matrizes em submatrizes
        int[][] A11 = new int[tamanho/2][tamanho/2];
        int[][] A12 = new int[tamanho/2][tamanho/2];
        int[][] A21 = new int[tamanho/2][tamanho/2];
        int[][] A22 = new int[tamanho/2][tamanho/2];
        int[][] B11 = new int[tamanho/2][tamanho/2];
        int[][] B12 = new int[tamanho/2][tamanho/2];
        int[][] B21 = new int[tamanho/2][tamanho/2];
        int[][] B22 = new int[tamanho/2][tamanho/2];

        dividirMatriz(A, A11, A12, A21, A22);
        dividirMatriz(B, B11, B12, B21, B22);

        // Calcular os produtos intermediários P1-P7
        int[][] P1 = multiply(somarMatrizes(A11, A22), somarMatrizes(B11, B22));
        int[][] P2 = multiply(somarMatrizes(A21, A22), B11);
        int[][] P3 = multiply(A11, subtrairMatrizes(B12, B22));
        int[][] P4 = multiply(A22, subtrairMatrizes(B21, B11));
        int[][] P5 = multiply(somarMatrizes(A11, A12), B22);
        int[][] P6 = multiply(subtrairMatrizes(A21, A11), somarMatrizes(B11, B12));
        int[][] P7 = multiply(subtrairMatrizes(A12, A22), somarMatrizes(B21, B22));

        // Calcular os elementos da matriz de resultado
        int[][] C11 = somarMatrizes(subtrairMatrizes(somarMatrizes(P1, P4), P5), P7);
        int[][] C12 = somarMatrizes(P3, P5);
        int[][] C21 = somarMatrizes(P2, P4);
        int[][] C22 = somarMatrizes(subtrairMatrizes(somarMatrizes(P1, P3), P2), P6);

        // Combinar os resultados em uma única matriz
        int[][] C = new int[tamanho][tamanho];
        combinarMatriz(C, C11, C12, C21, C22);

      
        return C;
    }

    // Funções auxiliares
    public static void dividirMatriz(int[][] matriz, int[][] a11, int[][] a12, int[][] a21, int[][] a22) {
        int mid = matriz.length / 2;
        for (int i = 0; i < mid; i++) {
            System.arraycopy(matriz[i], 0, a11[i], 0, mid);
            System.arraycopy(matriz[i], mid, a12[i], 0, mid);
            System.arraycopy(matriz[mid + i], 0, a21[i], 0, mid);
            System.arraycopy(matriz[mid + i], mid, a22[i], 0, mid);
        }
    }

    public static int[][] somarMatrizes(int[][] A, int[][] B) {
        int n = A.length;
        int[][] C = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                C[i][j] = A[i][j] + B[i][j];
            }
        }
        return C;
    }

    public static int[][] subtrairMatrizes(int[][] A, int[][] B) {
        int n = A.length;
        int[][] C = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                C[i][j] = A[i][j] - B[i][j];
            }
        }
        return C;
    }

    public static void combinarMatriz(int[][] C, int[][] c11, int[][] c12, int[][] c21, int[][] c22) {
        int meio = C.length / 2;
        for (int i = 0; i < meio; i++) {
            System.arraycopy(c11[i], 0, C[i], 0, meio);
            System.arraycopy(c12[i], 0, C[i], meio, meio);
            System.arraycopy(c21[i], 0, C[meio + i], 0, meio);
            System.arraycopy(c22[i], 0, C[meio + i], meio, meio);
        }
    }

    static void multiplyO3(int A[][], int B[][], int resultado[][]){ // Algoritmo normal de multiplicação de matrizes, O(n^3)
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
