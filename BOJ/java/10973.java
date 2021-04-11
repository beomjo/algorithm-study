import java.io.IOException;
import java.util.Scanner;

class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        sc.close();

        if (isPreviousPermutation(a)) {
            for (int i : a) {
                System.out.print(i + " ");
            }
            System.out.println();
        } else {
            System.out.println(-1);
        }
    }

    static boolean isPreviousPermutation(int[] a) {
        int lastIndex = a.length - 1;
        int i = lastIndex;
        while (i > 0 && a[i] > a[i - 1]) {
            i--;
        }
        if (i == 0) return false;

        int j = lastIndex;
        while (j >= i && a[j] > a[i - 1]) {
            j--;
        }
        swap(a, i - 1, j);

        j = lastIndex;
        while (i < j) {
            swap(a, i, j);
            i++;
            j--;
        }


        return true;
    }

    static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}