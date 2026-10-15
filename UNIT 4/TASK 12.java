import java.util.Scanner;

public class FirstUniqueCharacter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        int[] count = new int[256];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i)]++;
        }

        int index = -1;
        for (int i = 0; i < s.length(); i++) {
            if (count[s.charAt(i)] == 1) {
                index = i;
                break;
            }
        }
        System.out.println(index);
    }
}

Input/Output
  swiss
  Output:
1
