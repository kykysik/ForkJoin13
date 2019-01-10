package task1.parallel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class SecondProgram extends RecursiveTask<List<Integer>> {

    private int m;
    private int temp;
    private int matrix[][];
    private int vector[];
    private List<Integer> result;

    public SecondProgram(int m, int vector[], int matrix[][]) {
        this.m = m;
        this.matrix = matrix;
        this.vector = vector;
        result = new ArrayList<>(vector.length);
    }

    public SecondProgram(int matrix[][], int m, int vector[], List<Integer> result) {
        this.m = m;
        this.matrix = matrix;
        this.vector = vector;
        this.result = result;
    }

    @Override
    protected List<Integer> compute() {
        if (matrix.length > 1) {
            ForkJoinTask.invokeAll(createSubtasks());
        }else {
            result.add(processing(matrix, vector));
        }

        return result;
    }

    private List<SecondProgram> createSubtasks() {
        List<SecondProgram> subtasks = new ArrayList<>();

        subtasks.add(new SecondProgram(Arrays.copyOfRange(matrix, 0, matrix.length/2),  m, vector, result));
        subtasks.add(new SecondProgram(Arrays.copyOfRange(matrix, matrix.length/2, matrix.length),  m, vector, result));

        return subtasks;
    }

    private int processing(int matrix[][], int vector[]) {
        for (int j = 0; j < m; j++) {
            temp +=matrix[0][j] * vector[j];
        }
        return temp;
    }
}
