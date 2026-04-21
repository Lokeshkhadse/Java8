package Greedy_Algo.Fractional_Knapsack;

import java.util.Arrays;

public class Fractional_Knapsack {
    // 🔹 Item class to store value & weight
    static class Item {
        int value, weight;

        Item(int v, int w) {
            value = v;
            weight = w;
        }
    }

    public static void main(String[] args) {

        // 🔹 Input
        int[] val = {60, 100, 120};
        int[] wt  = {10, 20, 30};
        int capacity = 50;

        int n = val.length;

        // 🔹 Create items
        Item[] items = new Item[n];
        for (int i = 0; i < n; i++) {
            items[i] = new Item(val[i], wt[i]);
        }

        // 🔹 Sort by value/weight ratio (descending)
        Arrays.sort(items, (a, b) ->
                Double.compare((double)b.value / b.weight, (double)a.value / a.weight)
        );

        double total = 0.0;

        // 🔹 Greedy selection
        for (int i = 0; i < n; i++) {

            if (items[i].weight <= capacity) {
                total += items[i].value;
                capacity -= items[i].weight;
            }
            else {
                total += ((double)items[i].value / items[i].weight) * capacity;
                break;
            }
        }

        // 🔹 Output
        System.out.println("Maximum Value = " + total);
    }
}
