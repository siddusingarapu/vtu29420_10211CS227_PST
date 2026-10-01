import java.util.Scanner;
import java.util.TreeSet;

public class SortedMarks {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Create TreeSet
        TreeSet<Integer> marks = new TreeSet<>();

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        // Store marks
        for (int i = 0; i < n; i++) {
            System.out.print("Enter mark " + (i + 1) + ": ");
            int mark = sc.nextInt();

            marks.add(mark);
        }

        // Display unique marks in ascending order
        System.out.println("\nUnique Marks in Ascending Order:");

        for (int mark : marks) {
            System.out.println(mark);
        }

        sc.close();
    }
}

Input/Output
  Enter number of students: 5
Enter mark 1: 89
Enter mark 2: 77
Enter mark 3: 99
Enter mark 4: 80
Enter mark 5: 99

Unique Marks in Ascending Order:
77
80
89
99
