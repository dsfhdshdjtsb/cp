package idk;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        p3();
    }
    public static void p1() {
        Scanner scanner = new Scanner(System.in);
        int numberOfTestCases = scanner.nextInt();

        for(int i = 0; i < numberOfTestCases; i++) {
            int len = scanner.nextInt();
            String s = scanner.next();
            if(s.charAt(0) == s.charAt(s.length() - 1)) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
            }
        }
    }

    public static void p2() {
        Scanner scanner = new Scanner(System.in);
        int numberOfTestCases = scanner.nextInt();

        for(int i = 0; i < numberOfTestCases; i++) {
            int n = scanner.nextInt();
            int[] a = new int[n];
            for(int j = 0; j < n; j++){
                a[j] = scanner.nextInt();
            }
            Arrays.sort(a);
            System.out.println(a[n/2]);
        }
    }

    public static void p3() {
        Scanner scanner = new Scanner(System.in);
        int numberOfTestCases = 1000;

        for(int w = 0; w < numberOfTestCases; w++) {
//            int n = scanner.nextInt();
            String s = scanner.next();
            int pairs = 0;
            for(int i = 0; i < s.length(); i++) {

                for(int j = i+1; j < s.length(); j++) {
                    if(s.charAt(i) == s.charAt(j)) {
                        System.out.println(s.substring(i, j+1));
                        pairs++;
                        continue;
                    }
                    for(int k = i; k < j; k++) {
                        if(s.charAt(k) != s.charAt(k+1) && (s.charAt(i) != s.charAt(k) || s.charAt(k+1) != s.charAt(j))) {
                            System.out.println(s.substring(i, j+1));
                            pairs++;
                            break;
                        }
                    }
                }
            }
            System.out.println(pairs);

        }
    }

}
