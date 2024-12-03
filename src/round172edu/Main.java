
package round172edu;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        solution3();
    }

    public static void solution1() {
        Scanner scanner = new Scanner(System.in);
        int numberOfTestCases = scanner.nextInt();

        for (int testcase = 0; testcase< numberOfTestCases; testcase++) {

            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int[] arr = new int[n];
            int max = 0;
            for(int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }
            Arrays.sort(arr);
            long sum =0;

            for(int i = n -1; i >=0; i--) {

                if(sum + arr[i] <= k) {
                    sum += arr[i];
                } else {
                    break;
                }
            }

            System.out.println(k - sum);
        }
    }

    public static void solution2() {
        Scanner scanner = new Scanner(System.in);
        int numberOfTestCases = scanner.nextInt();

        for (int testcase = 0; testcase< numberOfTestCases; testcase++) {
            int n = scanner.nextInt();
            int[] arr = new int[n];
            Map<Integer, Integer> hm = new HashMap<>();
            for(int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
                hm.put(arr[i], hm.getOrDefault(arr[i], 0) + 1);
            }
            int ones = 0;
            int score = 0;
            for(int i : hm.values()) {
                if(i == 1) {
                    ones ++;
                }
                else {
                    score++;
                }
            }
            System.out.println(score + ((ones+1) / 2) *2);
        }
    }

    public static void solution3() {
        Scanner scanner = new Scanner(System.in);
        int numberOfTestCases = scanner.nextInt();

        for (int testcase = 0; testcase< numberOfTestCases; testcase++) {
            int n = scanner.nextInt();
            int[][] arr = new int[n][3];

            for(int i = 0; i < n; i ++) {
                arr[i][0] = scanner.nextInt();
                arr[i][1] = scanner.nextInt();
                arr[i][2] = i;
            }
            Arrays.sort(arr, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if(o1[0] == o2[0]) {
                        return Integer.compare(o2[1], o1[1]);
                    }
                    return Integer.compare(o1[0], o2[0]);
                }
            });
            for(int[] a : arr) {
                System.out.print(Arrays.toString(a) + ",");
                System.out.println();
            }
            int[] ans = new int[n];
            ArrayList<Integer> ends = new ArrayList<>();
            Map<Integer, Integer> hm = new HashMap<>();
            ends.add(arr[0][1]);
            hm.put(arr[0][1], arr[0][0]);
            for(int i =1; i < arr.length; i++) {
                int[] cur = arr[i];
                int index = Collections.binarySearch(ends, cur[1]);
                System.out.println(Arrays.toString(cur)+  index + ends.toString());
                if(index < 0) {
                    index = -index - 1;
                    if(index+1 < ends.size()) {
                        int start = hm.get(ends.get(index+1));
                        ans[cur[2]] = ends.get(index) - cur[1] + cur[0] - start;
                    }
                    ends.add(index, cur[1]);
                    hm.put(cur[1], cur[0]);
                } else {
                    int start = hm.get(ends.get(index));
                    ans[cur[2]] = cur[0] - start;
                    hm.put(cur[1], cur[0]);
                }
            }
            System.out.println("ANSWERS");
            for(int i : ans) {
                System.out.println(i);
            }
        }
    }
}
