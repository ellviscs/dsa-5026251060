package lw04.unguided;

import java.util.Scanner;

public class Main {
    static void selectionSort(int[] a, int passes) {
        for (int i = 0; i < passes && i < a.length; i++) {
            int minIndex = i;
            for (int j = i; j < a.length; j++) {
                if (a[minIndex] > a[j]) {
                    minIndex = j;
                }
            }
            int temp = a[i];
            a[i] = a[minIndex];
            a[minIndex] = temp;
        }
    }

    static int linearSearch(int[] a, int search) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == search) return i;
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(Main.class.getResourceAsStream("cards.txt"));
        int N = sc.nextInt();
        int[] cards = new int[N];

        for (int i = 0; i <  N; i++) {
            cards[i] = sc.nextInt();
        }

        selectionSort(cards, 2);

        for (int i = 0; i < cards.length; i++) {
            if (i > 0) System.out.print(" ");
            System.out.print(cards[i]);
        }
        System.out.println();

        int M = sc.nextInt();

        for (int i = 0; i < M; i++) {
            int search = sc.nextInt();
            int index = linearSearch(cards, search);

            if (index == -1) {
                System.out.println(search + ": NOT FOUND");
                continue;
            }

            System.out.println(search + ": FOUND at index " + index);
        }
        sc.close();
    }
}
