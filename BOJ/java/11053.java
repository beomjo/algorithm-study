import java.io.IOException;
import java.util.Scanner;

class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int[] d = new int[n];
        int max = -1;

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            d[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    d[i] = Math.max(d[i], d[j] + 1);
                }
            }

            if (max < d[i]) {
                max = d[i];
            }
        }
        sc.close();
        System.out.println(max);
    }
}
