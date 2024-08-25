package practice;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        C738();

    }

    public static void C738() {
        Scanner scanner = new Scanner(System.in);
        int numberOfTestCases = scanner.nextInt();

        outer:
        for (int i = 0; i < numberOfTestCases; i++) {
            int n = scanner.nextInt();
            int[] arr = new int[n];
            for(int j = 0; j < n; j++) {
                arr[j] = scanner.nextInt();
            }
            StringBuilder msg = new StringBuilder();
//            if(arr[0] == 1) {
//                msg.append(n+1).append(" ");
//                for(int j = 1; j <= n; j++) {
//                    msg.append(j).append(" ");
//                }
//                System.out.println(msg);
//                continue;
//            }
//
//            for(int j = 0; j < n - 1; j++) {
//                msg.append(i + 1).append(" ");
//                if(arr[j] == 0 && arr[j+1] == 1) {
//                    msg.append(n+1).append(" ");
//                    for(int k = j+1; k < n; k++) {
//                        msg.append(k+1).append(" ");
//                    }
//                    System.out.println(msg);
//                    continue outer;
//                }
//            }
            boolean done = false;
            for(int j = 0; j < arr.length; j++) {
                if(!done && arr[j] == 1) {
                    msg.append(n+1).append(" ");
                    done = true;
                }
                msg.append(j+1).append(" ");
            }
            if(!done) {
                if(arr[arr.length -1] == 0) {
                    msg.append(n+1).append(" ");
                } else {
                    msg.replace(0, msg.length(), "-1");
                }
            }
            System.out.println(msg);
//            if(arr[n-1] == 0) {
//                msg.append(n).append(" ");
//                msg.append(n+1).append(" ");
//                System.out.println(msg);
//            } else {
//                System.out.println(-1);
//            }
        }
    }

    public static void test() {

        for(int i = 0; i < 368; i++) {
            int random = (int)(Math.random() * 2);
            System.out.print(random + " ");
        }
    }
}
