import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int[] d = new int[11];
        d[0] = 1;
        d[1] = 1;
        d[2] = 2;
        for (int i = 3; i < 11; i++) {
            d[i] = d[i - 1] + d[i - 2] + d[i - 3];
        }
        while (t-- > 0) {
            int n = sc.nextInt();
            System.out.println(d[n]);
        }
        sc.close();
    }
}
