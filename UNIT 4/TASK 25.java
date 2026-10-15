import java.util.HashMap;
import java.util.Scanner;

public class FrequencyQueries {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();

        HashMap<Integer, Integer> freq = new HashMap<>();
        HashMap<Integer, Integer> freqCount = new HashMap<>();

        for (int i = 0; i < q; i++) {
            int type = sc.nextInt();
            int value = sc.nextInt();

            if (type == 1) {
                int old = freq.getOrDefault(value, 0);
                freqCount.put(old, freqCount.getOrDefault(old, 0) - 1);
                freq.put(value, old + 1);
                freqCount.put(old + 1, freqCount.getOrDefault(old + 1, 0) + 1);
            } else if (type == 2) {
                int old = freq.getOrDefault(value, 0);
                if (old > 0) {
                    freqCount.put(old, freqCount.get(old) - 1);
                    freq.put(value, old - 1);
                    freqCount.put(old - 1, freqCount.getOrDefault(old - 1, 0) + 1);
                }
            } else {
                if (freqCount.getOrDefault(value, 0) > 0) {
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
            }
        }
    }
}

Input/Output
  8
1 5
1 6
3 2
1 10
1 10
1 6
2 5

  Output
  0
3 2
1
