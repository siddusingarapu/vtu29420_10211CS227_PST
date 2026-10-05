import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

     public static List<Integer> maxSubarray(List<Integer> arr) {

        int maxSubarray = arr.get(0);
        int currentSum = arr.get(0);

        int maxSubsequence = arr.get(0);
        int maxElement = arr.get(0);

        for (int i = 1; i < arr.size(); i++) {

            int value = arr.get(i);

            currentSum = Math.max(value, currentSum + value);
            maxSubarray = Math.max(maxSubarray, currentSum);

            if (value > 0) {
                maxSubsequence += value;
            }
            maxElement = Math.max(maxElement, value);
        }

        if (maxSubsequence <= 0) {
            maxSubsequence = maxElement;
        }

        return Arrays.asList(maxSubarray, maxSubsequence);
    }
}


public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                    .map(Integer::parseInt)
                    .collect(toList());

                List<Integer> result = Result.maxSubarray(arr);

                bufferedWriter.write(
                    result.stream()
                        .map(Object::toString)
                        .collect(joining(" "))
                    + "\n"
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}


Input/Output
  Input (stdin)
2
4
1 2 3 4
6
2 -1 2 3 4 -5
Your Output (stdout)
10 10
10 11
Expected Output
10 10
10 11
