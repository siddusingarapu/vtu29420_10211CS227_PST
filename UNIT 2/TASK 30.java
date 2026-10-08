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

    /*
     * Complete the 'circularPalindromes' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts STRING s as parameter.
     */

    public static List<Integer> circularPalindromes(String s) {
    int n = s.length();
        List<Integer> answer = new ArrayList<>();

        // Try every rotation
        for (int start = 0; start < n; start++) {

            int maxLength = 1;

            // Check every possible center
            for (int center = 0; center < n; center++) {

                // Odd length palindrome
                int left = center;
                int right = center;

                while (left >= 0 && right < n &&
                       getChar(s, start, left) == getChar(s, start, right)) {

                    maxLength = Math.max(maxLength, right - left + 1);
                    left--;
                    right++;
                }

                // Even length palindrome
                left = center;
                right = center + 1;

                while (left >= 0 && right < n &&
                       getChar(s, start, left) == getChar(s, start, right)) {

                    maxLength = Math.max(maxLength, right - left + 1);
                    left--;
                    right++;
                }
            }

            answer.add(maxLength);
        }

        return answer;
    }

    private static char getChar(String s, int rotation, int index) {
        return s.charAt((rotation + index) % s.length());
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String s = bufferedReader.readLine();

        List<Integer> result = Result.circularPalindromes(s);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}


Input/Output
  Input (stdin)
13
aaaaabbbbaaaa
Your Output (stdout)
12
12
10
8
8
9
11
13
11
9
8
8
10
Expected Output
12
12
10
8
8
9
11
13
11
9
8
8
10
