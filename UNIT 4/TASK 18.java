import java.util.HashMap;
import java.util.Scanner;

public class TwoSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int target = sc.nextInt();

        HashMap<Integer, Integer> seen = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int need = target - nums[i];
            if (seen.containsKey(need)) {
                System.out.println("[" + seen.get(need) + ", " + i + "]");
                return;
            }
            seen.put(nums[i], i);
        }
        System.out.println("No two numbers add up to the target");
    }
}

Input/Output
  4
2 7 11 15
9
  Output
  [0, 1]
