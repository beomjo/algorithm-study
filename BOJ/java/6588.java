
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int end = 1000000;

        boolean[] check = new boolean[end + 1];
        check[1] = true;

        for (int i = 2; i <= end; i++) {
            for (int j = 2; i * j <= end; j++) {
                if (!check[i * j]) {
                    check[i * j] = true;
                }
            }
        }

        while (true) {
            int n = sc.nextInt();
            if (n == 0)
                break;
            for (int i = 2; i * 2 <= n; i++) {
                int a = i;
                int b = n - a;
                if (!check[a] && !check[b]) {
                    sb.append(n + " = " + a + " + " + b + "\n");
                    break;
                }
            }
        }
        System.out.println(sb);
    }
}
