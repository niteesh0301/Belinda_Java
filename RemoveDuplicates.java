import java.util.ArrayList;
import java.util.Random;

public class RemoveDuplicates {
    //remove duplicate elements logic
    public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list) {
        ArrayList<E> uniList = new ArrayList<>();

        for (E element : list) {

            if (!uniList.contains(element)) {

                uniList.add(element);
            }
        }

        return uniList;
    }

    public static void main(String[] args) {
        int i,rInt;


        ArrayList<Integer> integers = new ArrayList<>();
        //random integers list
        for (i = 0; i < 100; i++) {

            rInt = (int)(Math.random()*10);
            integers.add(rInt);
        }

        System.out.println("Integer List :");

        System.out.println(integers);

        ArrayList<Integer> uniIntegers = removeDuplicates(integers);

        System.out.println("Duplicates removed integers list:");
        System.out.println(uniIntegers);


        ArrayList<Character> chars = new ArrayList<>();
        Random random = new Random();
    //random char generating
        for (i = 0; i < 100; i++) {

            rInt =  random.nextInt(26);
            char randChar = (char) ('a' + rInt);
            chars.add(randChar);
        }

        System.out.println("character list:");
        System.out.println(chars);

        ArrayList<Character> uniChars = removeDuplicates(chars);

        System.out.println("Duplicates removed char list:");
        System.out.println(uniChars);
    }
}