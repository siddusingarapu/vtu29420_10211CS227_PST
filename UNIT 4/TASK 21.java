import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class HashtagFrequency {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        HashMap<String, Integer> count = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String tag = sc.next();
            count.put(tag, count.getOrDefault(tag, 0) + 1);
        }

        List<Map.Entry<String, Integer>> list = new ArrayList<>(count.entrySet());
        Collections.sort(list, (a, b) -> {
            if (!a.getValue().equals(b.getValue())) {
                return b.getValue() - a.getValue();
            }
            return a.getKey().compareTo(b.getKey());
        });

        for (Map.Entry<String, Integer> e : list) {
            System.out.println(e.getKey() + " " + e.getValue());
        }
    }
}

Input/Output
  8
#java
#code
#java
#python
#code
#java
#ai
#python

  
  Output
  #java 3
#code 2
#python 2
#ai 1
