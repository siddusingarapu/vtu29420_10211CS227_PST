import java.util.HashMap;
import java.util.Scanner;

public class MajorityElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        HashMap<Integer, Integer> count = new HashMap<>();
        for (int x : arr) {
            count.put(x, count.getOrDefault(x, 0) + 1);
        }

        int answer = -1;
        for (int key : count.keySet()) {
            if (count.get(key) > n / 2) {
                answer = key;
            }
        }

        if (answer == -1) {
            System.out.println("No majority element");
        } else {
            System.out.println(answer);
        }
    }
}

Input/Output
  3
3 2 3
  Output:
3
