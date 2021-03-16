import java.io.IOException;
import java.util.Scanner;

class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int e = sc.nextInt() - 1;
        int m = sc.nextInt() - 1;
        int s = sc.nextInt() - 1;

        for (int i = 0; ; i++) {
            if (i % 15 == e && i % 28 == m && i % 19 == s) {
                System.out.println(i + 1);
                sc.close();
                System.exit(0);
            }
        }
    }
}