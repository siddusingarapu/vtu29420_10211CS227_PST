import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MostFrequentWords {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        HashMap<String, Integer> count = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String word = sc.next();
            count.put(word, count.getOrDefault(word, 0) + 1);
        }
        int k = sc.nextInt();

        List<Map.Entry<String, Integer>> list = new ArrayList<>(count.entrySet());
        Collections.sort(list, (a, b) -> {
            if (!a.getValue().equals(b.getValue())) {
                return b.getValue() - a.getValue();
            }
            return a.getKey().compareTo(b.getKey());
        });

        for (int i = 0; i < k && i < list.size(); i++) {
            System.out.println(list.get(i).getKey() + " " + list.get(i).getValue());
        }
    }
}

Input?Output
  9
the
day
is
sunny
the
the
the
sunny
is
3

  Output
  the 4
is 2
sunny 2
