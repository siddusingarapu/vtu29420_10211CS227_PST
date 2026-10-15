import java.util.HashMap;
import java.util.Scanner;

public class DistinctInWindow {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();

        HashMap<Integer, Integer> window = new HashMap<>();
        int maxDistinct = 0;

        for (int i = 0; i < n; i++) {
            window.put(arr[i], window.getOrDefault(arr[i], 0) + 1);

            if (i >= k) {
                int out = arr[i - k];
                if (window.get(out) == 1) {
                    window.remove(out);
                } else {
                    window.put(out, window.get(out) - 1);
                }
            }

            if (i >= k - 1) {
                maxDistinct = Math.max(maxDistinct, window.size());
            }
        }
        System.out.println(maxDistinct);
    }
}

Input/Output
  7
1 2 1 3 4 2 3
4
  Output
  4
