package round163edu;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        solution3();
    }

    public static void solution1() {
        Scanner scanner = new Scanner(System.in);
        int numberOfTestCases = scanner.nextInt();

        for (int i = 0; i < numberOfTestCases; i++) {
            int num = scanner.nextInt();

            if(num % 2 == 1 ) {
                System.out.println("NO");
                continue;
            }
            System.out.println("Yes");
            String[] letters = new String[]{"AA", "BB"};
            for (int j = 0; j < num / 2; j++) {
                System.out.print(letters[j % 2]);
            }
            System.out.println();
        }
    }

    public static void solution2() {
        Scanner scanner = new Scanner(System.in);
        int numberOfTestCases = scanner.nextInt();

        outer:
        for (int i = 0; i < numberOfTestCases; i++) {
            int length = scanner.nextInt();
            int prev;
            Stack<Integer> stack = new Stack<>();
            for(int j = 0; j < length - 1; j++) {
                stack.add( scanner.nextInt() );
            }
            prev = scanner.nextInt();

            while(!stack.isEmpty()) {
                int top = stack.pop();
//                System.out.println(top + " " + prev);
                if(top <= prev) {
                    prev = top;
                    continue;
                }
                if(top < 10) {
                    System.out.println("NO");
                    continue outer;
                }
                int dig = (int) Math.log10(top);

                while(dig >= 0) {
                    int place = (int) Math.pow(10, dig);
                    stack.add((top / place) % 10);
                    dig--;
                }
            }
            System.out.println("YES");
        }

    }

    public static void solution3() {
        Scanner scanner = new Scanner(System.in);
        int numberOfTestCases = scanner.nextInt();

        outer:
        for (int i = 0; i < numberOfTestCases; i++) {
            int n = scanner.nextInt();
            String top = scanner.next();
            String bot = scanner.next();

            Stack<Pair> stack = new Stack<>();
            stack.add(new Pair(0, 1));
            HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
            map.put(0, new HashSet<>());
            map.put(1, new HashSet<>());


            while(!stack.isEmpty()) {
                Pair pos = stack.pop();
//                System.out.println(pos.x + " " + pos.y);
                if(pos.y == n) {
                    System.out.println("YES");
                    continue outer;
                }
                if(map.get(pos.x).contains(pos.y)) continue;
                map.get(pos.x).add(pos.y);

                Pair left = new Pair(pos.x, pos.y + 1);
                Pair vert = new Pair((pos.x + 1) % 2, pos.y);
                handlePair(left, stack, top, bot);
                handlePair(vert, stack, top, bot);
            }
            System.out.println("NO");
        }
    }

    public static void handlePair(Pair pair, Stack<Pair> stack, String top, String bot) {
        String loc = pair.x == 0 ? top : bot;

        char c = loc.charAt(pair.y - 1);

        if(c == '<') {
            return;
        } else {
            stack.add(new Pair(pair.x, pair.y + 1));

        }
    }
    public static class Pair {
        int x;
        int y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }
}


