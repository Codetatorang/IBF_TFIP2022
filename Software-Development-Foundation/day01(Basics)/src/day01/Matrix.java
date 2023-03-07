package src.day01;

public class Matrix {
    public static void main(String[] args) {
        Integer[][] matrix = new Integer[4][3];
        matrix[0][0] = 10;
        System.out.printf("rows: %d\n", matrix.length);
        System.out.printf("cols: %d\n", matrix[0].length);
        System.out.printf("value at 0,0: %d\n", matrix[0][0]);
    }
}
