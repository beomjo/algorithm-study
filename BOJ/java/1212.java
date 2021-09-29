/*
 * 8진수 2진수 
 * https://www.acmicpc.net/problem/1212
 */

import java.io.*;
import java.util.Scanner;

class Main {
    static String[] octToBin = {"000", "001", "010", "011", "100", "101", "110", "111"};
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        char[] oct = sc.next().toCharArray();

        if (oct.length == 1 && oct[0] == '0') {
            System.out.println(0);
            return;
        }

        for (char c : oct) {
            sb.append(octToBin[c - '0']);
        }

        while (sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        System.out.println(sb.toString());
        sc.close();
    }
}