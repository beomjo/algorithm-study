import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        //solveOne();
        solveTwo();
    }

    private static void solveOne() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int countOfTwo = 0;
        int countOfFive = 0;
        for (int i = 1; i <= n; i++) {
            int target = i;
            while (target % 2 == 0) {
                countOfTwo++;
                target /= 2;
            }

            while (target % 5 == 0) {
                countOfFive++;
                target /= 5;
            }
        }

        System.out.println(Math.min(countOfTwo, countOfFive));
        sc.close();
    }

    private static void solveTwo() {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        s.close();
        int count = 0;
        while (n >= 5) {
            count += n / 5;
            n /= 5;
        }
        System.out.println(count);
    }
}
