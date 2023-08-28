package practice.unit_tests;

public class ArraySum {
    public static void main(String[] args) {

        int [] array = new int[10];
        int a = -10;
        int b = 10;

        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * (b - a + 1) + a);
        }
        printArray(array);

        int res = sumElOddIndex(array);
        System.out.println("Sum of " + res);

    }

    public static int sumElOddIndex(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i % 2 != 0){
                sum = sum + arr[i];
            }
        }
        return sum;
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }




}
