package task1.parallel;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.concurrent.ForkJoinPool;

public class Start {

    private static int m;
    private static int n;
    private static int c;

    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Введіть розмірність стовпців  матриці:");
        m = Integer.parseInt(reader.readLine());
        System.out.println("Введіть розмірність рядків матриці:");
        n = Integer.parseInt(reader.readLine());
        System.out.println("Введіть розмірність вектору:");
        c = Integer.parseInt(reader.readLine());

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
        SecondProgram test = new SecondProgram(m, vector, matrix);
        ForkJoinPool forkJoinPool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());

        Long beginT = System.nanoTime();
        System.out.println("Результат");
        System.out.println(forkJoinPool.invoke(test));
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
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = j + 1;
            }
        }
        return result;
    }
}