import java.io.IOException;
import java.util.Scanner;

class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int s = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        int result = 0;
        for (int i = 1; i < (1 << n); i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                if (getBit(i, j)) {
                    sum += a[j];
                }
            }
            if (sum == s) {
                result++;
            }
        }

        System.out.println(result);
    }

    static boolean getBit(int num, int i) {
        return (num & (1 << i)) != 0;
    }
}