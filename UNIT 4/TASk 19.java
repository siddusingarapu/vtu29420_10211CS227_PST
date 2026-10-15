import java.util.Scanner;
import java.util.TreeMap;

public class MigratoryBirds {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        TreeMap<Integer, Integer> count = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            int id = sc.nextInt();
            count.put(id, count.getOrDefault(id, 0) + 1);
        }

        int bestId = 0;
        int bestCount = 0;
        for (int id : count.keySet()) {
            if (count.get(id) > bestCount) {
                bestCount = count.get(id);
                bestId = id;
            }
        }
        System.out.println(bestId);
    }
}
Input/Output
  6
1 4 4 4 5 3
  Output
  4
