
import java.io.IOException;
import java.util.Scanner;

class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] d = new int[n];
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        sc.close();

        d[0] = arr[0];

        for (int i = 1; i < n; i++) d[i] = Math.max(arr[i] + d[i - 1], arr[i]);

        int max = -1001;
        for (int i = 0; i < n; i++) {
            if (max < d[i]) {
                max = d[i];
            }
        }
        System.out.println(max);
    }
}