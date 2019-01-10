package task1.single;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class FirstProgram {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Введіть розмірність стовпців  матриці:");
        int m = Integer.parseInt(reader.readLine());
        System.out.println("Введіть розмірність рядків матриці:");
        int n = Integer.parseInt(reader.readLine());
        System.out.println("Введіть розмірність вектору:");
        int c = Integer.parseInt(reader.readLine());

        if(m!=c) {
            throw new Exception("Розмірність стовпців матриці не співпадає з розмірніст'ю вектора");
        }

        int vector[] = generate(c);
        int matrix[][] = generate(n,m);

        System.out.println("Вектор:");
        for (int aVector : vector) {
            System.out.println(aVector);
        }

        System.out.println("Матриця:");
        for (int[] anArr : matrix) {
            for (int anAnArr : anArr) {
                System.out.print(anAnArr + " ");
            }
            System.out.println();
        }

        Long beginT = System.nanoTime();
        int result[] = mult(vector, n, m, matrix);

        System.out.println("Результат:");
        for (int aResult : result) {
            System.out.println(aResult);
        }
        Long endT = System.nanoTime();
        Long timebetweenStartEnd = endT - beginT;
        System.out.println("=====time========" +timebetweenStartEnd);

    }

    private static int[] generate(int x) {
        int result[] = new int[x];
        for(int i = 0; i<x; i++) {
            result[i] = i;
        }
        return result;
    }

    private static int[][] generate(int m, int n) {
        int result[][] = new int[m][n];
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                result[i][j] = j + 1;
            }
        }
        return result;
    }

    private static int[] mult(int[] vector, int m, int n, int[][] matrix) {
        int result[] = new int[m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result[i] += matrix[i][j] * vector[j];
            }
        }
        return result;
    }
}
