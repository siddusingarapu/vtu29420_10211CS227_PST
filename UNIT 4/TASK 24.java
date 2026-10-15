import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class GroupAnagrams {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] words = sc.nextLine().split(" ");

        Map<String, List<String>> groups = new LinkedHashMap<>();
        for (String word : words) {
            char[] letters = word.toCharArray();
            Arrays.sort(letters);
            String key = new String(letters);

            if (!groups.containsKey(key)) {
                groups.put(key, new ArrayList<>());
            }
            groups.get(key).add(word);
        }

        for (List<String> group : groups.values()) {
            System.out.println(group);
        }
    }
}

Input/Output
  eat tea tan ate nat bat

  Output
  [eat, tea, ate]
[tan, nat]
[bat]
