class Solution {
    public boolean rotateString(String s, String goal) {

        // Lengths must be equal
        if (s.length() != goal.length()) {
            return false;
        }

        // Every rotation of s will appear inside s + s
        String doubled = s + s;

        return doubled.contains(goal);
    }
}

Input/Output
  Input
s =
"abcde"
goal =
"cdeab"
Output
true
Expected
true
