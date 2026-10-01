import java.util.ArrayList;
import java.util.Scanner;

public class StudentMarksManagementt {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Integer> marks = new ArrayList<>();
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        // Store marks
        for (int i = 0; i < n; i++) {
            System.out.print("Enter mark for student " + (i + 1) + ": ");
            marks.add(sc.nextInt());
        }

        // Display marks
        System.out.println("\nStudent Marks:");
        for (int mark : marks) {
            System.out.println(mark);
        }

        // Find highest mark
        int highest = marks.get(0);
        int sum = 0;

        for (int mark : marks) {
            if (mark > highest) {
                highest = mark;
            }
            sum += mark;
        }

        // Calculate average
        double average = (double) sum / marks.size();

        System.out.println("\nHighest Mark: " + highest);
        System.out.println("Average Mark: " + average);

        sc.close();
    }
}

Input/Output
  Enter number of students: 5 
Enter mark for student 1: 66
Enter mark for student 2: 35
Enter mark for student 3: 88
Enter mark for student 4: 79
Enter mark for student 5: 90

Student Marks:
66
35
88
79
90

Highest Mark: 90
Average Mark: 71.6
