
import java.util.Scanner;

class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int tc = sc.nextInt();
            int[] arr = new int[tc];
            long sum = 0;

            for (int i = 0; i < tc; i++) {
                arr[i] = sc.nextInt();
            }

            for (int i = 0; i < tc; i++) {
                for (int j = i + 1; j < tc; j++) {
                    sum += getGCD(arr[i], arr[j]);
                }
            }
            System.out.println(sum);
        }
        sc.close();
    }

    static int getGCD(int a, int b) {
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
}

