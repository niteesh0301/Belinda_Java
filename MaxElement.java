import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class MaxElement {

    public static <E extends Comparable<E>> E max(E[] list) {

        E max = list[0];
        //max element logic
        for (int i = 1; i < list.length ; i++ ) {

            if ( list[i].compareTo( max) >  0) {
                max =  list[i];
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int i,maxInteger;
        Integer[] integers = new Integer[100];
        Random random = new Random();
        //random integer array
        for (i = 0; i < integers.length; i++) {

            integers[i] = random.nextInt(10001);
        }

        System.out.println("Integer array:");
        Arrays.sort(integers, Comparator.reverseOrder());
        System.out.println(Arrays.toString(integers));


        maxInteger = max(integers);

        System.out.println("Max integer element:");
        System.out.println(maxInteger);


        Double[] doubles = new Double[100];
        //random double array
        for (i = 0;  i < doubles.length;  i++) {

            doubles[i] = random.nextDouble();

        }

        System.out.println("Double array:");
        Arrays.sort(doubles, Comparator.reverseOrder());
        System.out.println(Arrays.toString(doubles));

        Double maxDouble = max(doubles);

        System.out.println("Maximum double element:");

        System.out.println(maxDouble);
    }
}