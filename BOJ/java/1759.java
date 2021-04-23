import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

class Main {
    static int l, c;
    static String[] a, t;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        l = sc.nextInt();
        c = sc.nextInt();
        sc.nextLine();
        a = sc.nextLine().split(" ");
        t = new String[c];
        Arrays.sort(a);

        dfs(0, 0);
        System.out.println(sb);
    }

    static void dfs(int at, int depth) {
        if (depth == l && isPossible(t)) {
            for (int i = 0; i < l; i++) {
                sb.append(t[i]);
            }
            sb.append("\n");
            return;
        }

        for (int i = at; i < c; i++) {
            t[depth] = a[i];
            dfs(i + 1, depth + 1);
        }
    }

    static boolean isPossible(String[] s) {
        int vowel = 0, consonant = 0;
        for (int i = 0; i < l; i++) {
            if (isVowel(s[i])) vowel++;
            else consonant++;
        }
        return vowel >= 1 && consonant >= 2;
    }

    static boolean isVowel(String s) {
        char a = s.charAt(0);
        return a == 'a' || a == 'e' || a == 'i' || a == 'o' || a == 'u';
    }
}