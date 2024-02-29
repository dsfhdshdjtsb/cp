package round930;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        solution2(args);
    }

    public static void solution1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfTestCases = scanner.nextInt();

        for (int i = 0; i < numberOfTestCases; i++) {
            int size = scanner.nextInt();

            int pow = (int) (Math.log(size) / Math.log(2));

            System.out.println((int)Math.pow(2, pow));
        }
    }

    public static void solution2(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfTestCases = scanner.nextInt();

        for(int i = 0; i < numberOfTestCases; i++) {
            int size = scanner.nextInt();

            String top = scanner.next();
            String bot = scanner.next();
            int count = 1;
            String result = "" + top.charAt(0);
            for(int j = 0; j < size; j++) {
                char cur = top.charAt(j);
                if(j == size - 1) {
                    result += bot.charAt(j);
                    break;
                }
                char next = top.charAt(j + 1);
                char bnext = bot.charAt(j);
                if(next == bnext) {
                    count++;
                    result += next;
                } else if (next == '0') {
                    count = 1;
                    result += next;
                } else if (bnext == '0') {
                    result += bot.substring(j);
                    break;
                } else {
                    System.out.println("CHECK");
                }
            }
            System.out.println(result);
            System.out.println(count);

        }
    }
}