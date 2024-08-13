import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class BinarySearch {
    //binary search start here
    public static <E extends Comparable<E>> int binarySearch(E[] list, E key) {
        int start = 0;
        int End = list.length - 1;

        while (start <= End) {
            int mid = (start + End) / 2;
            int comparison = key.compareTo(list[mid]);

            if (comparison == 0) {

                return mid;

            }
            else if (comparison < 0) {

                End = mid - 1;
            }
            else
            {
                start = mid + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Random rand = new Random();

        int i,rInt;

        Integer[] integers = new Integer[100];
        //random interger array
        for (i = 0; i < integers.length; i++) {

            integers[i] = rand.nextInt(100);
        }

        System.out.println("integers array:");
        //sorting the integer array
        Arrays.sort(integers);
        System.out.println(Arrays.toString(integers));

        System.out.print("please Enter any integer to search: ");
        int keyInteger = input.nextInt();

        int Index = binarySearch(integers, keyInteger);

        if (Index != -1 )
        {

            System.out.println("At index: " + Index +" integer found");
        }
        else {
            System.out.println("The integer you entered is not found");
        }


        String[] strings = new String[10];
        //random string array
        for (i = 0; i < strings.length; i++) {

            StringBuilder stringBuilder = new StringBuilder();

            rInt = (int)(Math.random()*10)+1;
            for (int j = 0; j < rInt; j++) {

                rInt =  rand.nextInt(26);
                char randChar = (char) ('a' + rInt);
                stringBuilder.append(randChar);
            }
            strings[i] = stringBuilder.toString();
        }

        System.out.println("strings array:");
        //sorting the string array
        Arrays.sort(strings);

        System.out.println(Arrays.toString(strings));

        System.out.print("Please enter a string to search: ");
        String keyString = input.next();

        int strIndex = binarySearch(strings, keyString);

        if (strIndex != -1)
        {
            System.out.println("At index: " + strIndex + " string found");
        } else
        {
            System.out.println("The string you entered is not found");
        }


        Employee[] employees = new Employee[5];
        //employee array

        for (i = 0; i < employees.length; i++)
        {
            String firstName = generateRandomString(5);
            String lastName = generateRandomString(5);
            long salary = rand.nextInt(75000,100000);

            employees[i] = new Employee(firstName, lastName, salary);
        }

        System.out.println("Employee array:");
        Arrays.sort(employees);
        System.out.println(Arrays.toString(employees));

        System.out.print("Please enter first name to search: ");
        String searchFirstName = input.next();

        System.out.print("Please enter last name to search: ");
        String searchLastName = input.next();

        Employee searchEmployee = new Employee(searchFirstName, searchLastName,0);
        int employeeIndex = binarySearch(employees, searchEmployee);

        if (employeeIndex != -1) {
            System.out.println("At index" + employeeIndex+" employee found");
        } else {
            System.out.println("Employee not found");
        }
    }
    //random String generate
    public static String generateRandomString(int length) {
        Random rand = new Random();
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < length; i++) {
            char randChar = (char) ('a' + rand.nextInt(26));
            stringBuilder.append(randChar);
        }

        return stringBuilder.toString();
    }

    static class Employee implements Comparable<Employee> {
        private String firstName;
        private String lastName;
        private long salary;


        public Employee(String firstName, String lastName, long salary) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.salary = salary;
        }
        //compareTo implementation to sort employee based on first name and last name
        @Override
        public int compareTo(Employee other) {

            int firstNameComparison = firstName.compareTo(other.firstName);
            if (firstNameComparison == 0) {
                if (lastName.compareTo(other.lastName)==1)
                {
                    return 1;
                } else if (lastName.compareTo(other.lastName)==-1) {
                    return -1;

                }
                else return 0;

            }
            else {
                if (firstName.compareTo(other.firstName)==1)
                {
                    return 1;
                } else if (firstName.compareTo(other.firstName)==-1) {
                    return -1;

                }


            }
            return firstNameComparison;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    ", salary=" + salary +
                    '}';
        }
    }
}