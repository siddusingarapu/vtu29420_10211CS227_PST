import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            String s = sc.next();

            int n = s.length();
            int[] a = new int[26];
            int[] b = new int[26];

            for (int i = 0; i < n / 2; i++) {
                a[s.charAt(i) - 'a']++;
                b[s.charAt(n - 1 - i) - 'a']++;
            }

            if (Arrays.equals(a, b))
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}

Input/Output
Sample Input
6
gaga
abcde
rotor
xyzxy
abbaab
ababc
Your Output
YES
NO
YES
YES
NO
NO
  
