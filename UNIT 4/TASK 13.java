import java.util.HashMap;
import java.util.Scanner;

public class DegreeOfArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        HashMap<Integer, Integer> count = new HashMap<>();
        HashMap<Integer, Integer> first = new HashMap<>();
        HashMap<Integer, Integer> last = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int x = arr[i];
            count.put(x, count.getOrDefault(x, 0) + 1);
            if (!first.containsKey(x)) {
                first.put(x, i);
            }
            last.put(x, i);
        }

        int degree = 0;
        for (int c : count.values()) {
            degree = Math.max(degree, c);
        }

        int minLength = n;
        for (int x : count.keySet()) {
            if (count.get(x) == degree) {
                int length = last.get(x) - first.get(x) + 1;
                minLength = Math.min(minLength, length);
            }
        }

        System.out.println("Degree of array: " + degree);
        System.out.println("Smallest subarray length: " + minLength);
    }
}

Input/Output
  5
1 2 2 3 1
  Output
  Degree of array: 2
Smallest subarray length: 2
