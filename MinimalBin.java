import java.util.ArrayList;
import java.util.Scanner;

public class MinimalBin {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Please enter no of items: ");

        int numOfItems = sc.nextInt();

        ArrayList<Double> weights = new ArrayList<>();
        System.out.print("Please enter weights of items: ");
        //add weights to list
        for (int i = 0; i < numOfItems; i++) {
            double weight = sc.nextDouble();
            weights.add(weight);
        }

        //sort the weights in descending order
        for (int i = 0; i < weights.size() - 1; i++) {
            for (int j = i + 1; j < weights.size(); j++) {
                if (weights.get(i) < weights.get(j)) {
                    double temp = weights.get(i);
                    weights.set(i, weights.get(j));
                    weights.set(j, temp);
                }
            }
        }
        ArrayList<Bin> bins = new ArrayList<>();
        for (double weight : weights) {
            boolean added = false;
            for (Bin bin : bins) {
                if (bin.addItem(weight)) {
                    added = true;
                    break;
                }
            }

            if (!added )
            {
                Bin newBin = new Bin(10.0);
                bins.add(newBin);
                newBin.addItem(weight);


            }
        }

        System.out.println("Number of bins needed: " + bins.get(0).getNumberOfObjects());

        for (Bin bin : bins) {
            System.out.println(bin);
        }
    }
}
class Bin {
    private ArrayList<Double> items;
    private double maxWeight;
    private double totalWeight;
    private static int count=0,j=1;



    public Bin(double maxWeight) {
        items = new ArrayList<>();
        this.maxWeight = maxWeight;
        totalWeight = 0.0;
        count++;
    }

    public boolean addItem(double weight) {
        if (totalWeight + weight <= maxWeight) {

            items.add(weight);
            totalWeight += weight;
            return true;
        }
        return false;
    }

    public int getNumberOfObjects() {
        return count;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Container ").append(j++).append(" contains objects with weight ");
        for (int i = 0; i < items.size(); i++) {
            sb.append(items.get(i));
            if (i < items.size() - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}

