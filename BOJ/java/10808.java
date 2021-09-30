/*
 * 알파벳 개수
 * https://www.acmicpc.net/problem/10808
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int[] alphabet = new int[26];

        for (int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i) - 97;
            alphabet[idx]++;
        }

        for (int i = 0; i < alphabet.length; i++) {
            System.out.print(alphabet[i] + " ");
        }
    }
}