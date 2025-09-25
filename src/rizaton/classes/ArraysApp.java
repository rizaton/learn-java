package rizaton.classes;

import java.util.Arrays;

public class ArraysApp {
    public static void main(String[] args) {

        double[] numbers = {
                10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0.5, 200, 923, 534
        };
        Arrays.sort(numbers);
        System.out.println(Arrays.toString(numbers));

        System.out.println(Arrays.binarySearch(numbers, 9));
        System.out.println(Arrays.binarySearch(numbers, 0.5));

        double[] result = Arrays.copyOf(numbers,5);
        System.out.println(Arrays.toString(result));

        double[] result1 = Arrays.copyOfRange(numbers,5, 10);
        System.out.println(Arrays.toString(result1));

    }
}
