class Solution {
    public int daysBetweenDates(String date1, String date2) {
        java.time.LocalDate d1 = java.time.LocalDate.parse(date1);
        java.time.LocalDate d2 = java.time.LocalDate.parse(date2);
        return (int) Math.abs(java.time.temporal.ChronoUnit.DAYS.between(d1,d2));
         }
}

output
Input
date1 =
"2019-06-29"
date2 =
"2019-06-30"
Output
1
Expected
1
