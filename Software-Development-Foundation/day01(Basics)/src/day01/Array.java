package src.day01;

import java.util.Arrays;

public class Array {
    public static void main(String[] args) {
        Integer[] matrix = new Integer[6];

        //Size of the array
        System.out.printf("Size of the matrix: %d\n", matrix.length);

        matrix[0] = 0;
        matrix[1] = 1;
        matrix[2] = 2;
        matrix[3] = 3;
        matrix[4] = 4;
        matrix[5] = 5;

        System.out.println(">>> matrix: " + Arrays.toString(matrix));
        
        //use a while loop to loop through the array matrix
        Integer i = 0;

        while(i < matrix.length){
            System.out.printf(">>>%d\n", matrix[i]);
            i++;
        }

        for(i = 0; i < matrix.length; i++){
            System.out.printf("for-loop: %d\n", matrix[i]);
        }

    }
}
