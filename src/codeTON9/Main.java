package codeTON9;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        solution4();
    }

    public static void solution1() {
        Scanner scanner = new Scanner(System.in);
        int numberOfTestCases = scanner.nextInt();

        for (int testcase = 0; testcase < numberOfTestCases; testcase++) {
            int n = scanner.nextInt();

            StringBuilder res = new StringBuilder();
            for(int i = 1; i <=n; i++) {
                res.append(i-1 + i);
                res.append(' ');
            }
            System.out.println(res.toString());
        }
    }

    public static void solution2() {
        Scanner scanner = new Scanner(System.in);
        int numberOfTestCases = scanner.nextInt();

        for (int testcase = 0; testcase < numberOfTestCases; testcase++) {
            String str = scanner.next();
            if(str.length() == 1) {
                System.out.println(-1);
                continue;
            }

            char[] win = new char[2];
            win[0] = ' ';
            win[1] = str.charAt(0);
            StringBuilder result = new StringBuilder();
            for(int i = 1; i < str.length(); i++) {
                 if(str.charAt(i) == win[1]) {
                     result.append(win[1]).append(win[1]);
                     break;
                 } else if (win[0] != ' ' && str.charAt(i) != win[1] && str.charAt(i) != win[0]) {
                     result.append(win[0]).append(win[1]).append(str.charAt(i));
                     break;
                 }
                 win[0] = win[1];
                 win[1] = str.charAt(i);
            }
            if(result.isEmpty()) {
                result.append("-1");
            }
            System.out.println(result);
        }
    }

    public static void solution3() {
        Scanner scanner = new Scanner(System.in);
        int numberOfTestCases = scanner.nextInt();

        for (int testcase = 0; testcase < numberOfTestCases; testcase++) {
            int x = scanner.nextInt();
            long m = scanner.nextLong();

            int count = 0;

            int next1 = (int) (Math.log(x)/Math.log(2) +1);
            double bound = Math.pow(2, next1);
            for(int y = 1; y <= m && y < bound; y++) {
                int xor = y ^ x;

                if(xor != 0 && y != x && (x % xor == 0 || y % xor == 0)) {
                    count++;
                }
            }

            System.out.println(count);
        }
    }

    public static void solution4() {
        Scanner scanner = new Scanner(System.in);
        int numberOfTestCases = scanner.nextInt();

        for (int testcase = 0; testcase < numberOfTestCases; testcase++) {
            int x = scanner.nextInt();
            long m = scanner.nextLong();

            int count = 0;
            for(int y = 1; y <= x; y++) {
                int xor = y ^ x;
                if(xor % x == 0 || xor % y == 0) {
                    count++;
                }
            }
            System.out.println("count: " + count);
            String mBin = Long.toBinaryString(m);
            String xBin = Integer.toBinaryString(x);

            StringBuilder boundBin = new StringBuilder(mBin);
            boolean lesser = false;
            for(int i = xBin.length() - 1; i >= 0; i--) {
                if(xBin.charAt(i) == '1' && boundBin.charAt(i) == '1') {
                    boundBin.setCharAt(i, '0');
                    lesser = true;
                } else if (lesser) {
                    boundBin.setCharAt(i, '1');
                }
            }
            long bound = x ^ Long.parseLong(boundBin.toString(), 2);
            System.out.println(Long.parseLong(boundBin.toString(), 2));
            long upper = bound / x;
            System.out.println(count + upper);
        }
    }
}
