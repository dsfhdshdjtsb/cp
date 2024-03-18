package round931;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        solution2();
    }

    public static void solution1() {

        Scanner scanner = new Scanner(System.in);
        int numberOfTestCases = scanner.nextInt();

        for (int i = 0; i < numberOfTestCases; i++) {
            int length = scanner.nextInt();
            PriorityQueue<Integer> min = new PriorityQueue<>();
            PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());

            for (int j = 0; j < length; j++) {
                int cur = scanner.nextInt();
                min.offer(cur);
                max.offer(cur);
            }

            int big1 = max.poll();
            int big2 = max.poll();
            int small1 = min.poll();
            int small2 = min.poll();

            int answer = Math.abs(small1 - big1) + Math.abs(big1 - small2) + Math.abs(small2 - big2) + Math.abs(big2 - small1);

            System.out.println(answer);
        }
        scanner.close();
    }

    public static void solution2() {
        Scanner scanner = new Scanner(System.in);
        int numberOfTestCases = scanner.nextInt();
        int[] coins = new int[]{1, 3, 6, 10, 15};

        for (int z = 0; z < numberOfTestCases; z++) {
            int amount = scanner.nextInt();

            int[] dp = new int[amount+1];
            dp[0] = 0;
            for(int i = 1; i <= amount; i++) {
                dp[i] = amount + 1;
                for(int j = 0; j < coins.length; j++) {
                    if(i >= coins[j]) {
                        dp[i] = Math.min(dp[i], dp[i-coins[j]] + 1);
                    }
                }
            }
            System.out.println( dp[amount]);
        }
    }

}
