
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        boolean[] check = new boolean[1000001];
        StringBuilder sb = new StringBuilder();

        int min = sc.nextInt();
        int max = sc.nextInt();

        check[1] = true;

        for (int i = 2; i <= max; i++) {
            for (int j = 2; i * j <= max; j++) {
                if (!check[i * j]) {
                    check[i * j] = true;
                }
            }
        }

        for (int i = min; i <= max; i++) {
            if (!check[i]) {
                sb.append(i).append("\n");
            }
        }

        System.out.println(sb);
        sc.close();
    }
}



