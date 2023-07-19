package ShoppingList;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final int SHOPPING_LIST = 5;

        String[] masOfProducts = new String[SHOPPING_LIST];
        Integer[] masOfCosts = new Integer[SHOPPING_LIST];
        Integer[] masOfCounts = new Integer[SHOPPING_LIST];
        int count = 0;
        while (sc.hasNext() && count <= SHOPPING_LIST) {
            String s = sc.nextLine();
            if ("exit".equals(s)) {
                break;
            }
            count++;

            String[] parts = s.split(" ");

            if(parts.length != 3){
                System.out.println("Wrong number of arguments! Retry!");
                continue;
            }

            String productName = parts[0];
            int productCost;
            int productCount;
            try {
                productCost = Integer.parseInt(parts[1]);
                productCount = Integer.parseInt(parts[2]);
            } catch (NumberFormatException ex){
                System.out.println(ex.getMessage());
                System.out.println("Retry!");
                continue;
            }

            boolean productAlreadyExists = false;
            for (int i = 0; i < SHOPPING_LIST; i++) {
                if (productName.equals(masOfProducts[i])) {
                    masOfCosts[i] = productCost;
                    masOfCounts[i] += productCount;
                    productAlreadyExists = true;
                }
            }

            if (!productAlreadyExists) {
                for (int i = 0; i < SHOPPING_LIST; i++) {
                    if (masOfProducts[i] == null) {
                        masOfProducts[i] = productName;
                        masOfCosts[i] = productCost;
                        masOfCounts[i] = productCount;
                        break;
                    }
                }
            }
        }
        String[] sortedProducts = new String[SHOPPING_LIST];

        System.arraycopy(masOfProducts, 0, sortedProducts, 0, SHOPPING_LIST);
        Arrays.sort(sortedProducts, (String o1, String o2) -> {
            int res = String.CASE_INSENSITIVE_ORDER.compare(o1, o2);
            if (res == 0) {
                res = o1.compareTo(o2);
            }
            return res;
        });
        System.out.println(Arrays.toString(sortedProducts));
        long sum = 0;
        for (int i = 0; i < SHOPPING_LIST; i++) {
            sum += (long) masOfCosts[i] * masOfCounts[i];
        }
        System.out.println(sum);
        int indexOfMostPopularProduct = 0;
        for (int i = 0; i < SHOPPING_LIST; i++) {
            if (masOfCounts[i] > masOfCounts[indexOfMostPopularProduct]) {
                indexOfMostPopularProduct = i;
            }
        }
        for (int j = 0; j < 3; j++) {
            indexOfMostPopularProduct = 0;
            for (int i = 0; i < SHOPPING_LIST; i++) {
                if (masOfCounts[i] >
                        masOfCounts[indexOfMostPopularProduct]) {
                    indexOfMostPopularProduct = i;
                }
            }
        }
        System.out.println("Most popular product is " + masOfProducts[indexOfMostPopularProduct]);
        masOfProducts[indexOfMostPopularProduct] = null;
        masOfCounts[indexOfMostPopularProduct] = 0;
        masOfCosts[indexOfMostPopularProduct] = 0;
    }
}