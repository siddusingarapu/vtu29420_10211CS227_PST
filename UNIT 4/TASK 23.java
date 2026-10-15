import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class TopKFrequent {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        HashMap<Integer, Integer> count = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            count.put(x, count.getOrDefault(x, 0) + 1);
        }
        int k = sc.nextInt();

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(count.entrySet());
        Collections.sort(list, (a, b) -> {
            if (!a.getValue().equals(b.getValue())) {
                return b.getValue() - a.getValue();
            }
            return a.getKey() - b.getKey();
        });

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < k && i < list.size(); i++) {
            result.add(list.get(i).getKey());
        }
        System.out.println(result);
    }
}

Input/Output
  6
1 1 1 2 2 3
2
  Output
  [1, 2]
