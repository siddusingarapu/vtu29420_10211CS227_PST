import java.util.Scanner;

public class StudentMarksManagement {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] marks = new int[2];

        int count = 0;

        System.out.println("Enter student marks");
        System.out.println("Enter -1 to stop");

        while (true) {

            System.out.print("Enter marks: ");
            int mark = sc.nextInt();
            if (mark == -1) {
                break;
            }
            if (count == marks.length) {
                int[] newMarks = new int[marks.length * 2];
                for (int i = 0; i < marks.length; i++) {
                    newMarks[i] = marks[i];
                }
                marks = newMarks;

                System.out.println("Array size increased to "
                                   + marks.length);
            }
            marks[count] = mark;
            count++;
        }
        System.out.println("\nStudent Marks:");

        for (int i = 0; i < count; i++) {
            System.out.println("Student " + (i + 1)
                               + ": " + marks[i]);
        }

        sc.close();
    }
}



Input/Output

  Enter student marks
Enter -1 to stop
Enter marks: 75
Enter marks: 82
Enter marks: 90
Array size increased to 4
Enter marks: 65
Enter marks: 88
Array size increased to 8
Enter marks: -1

Student Marks:
Student 1: 75
Student 2: 82
Student 3: 90
Student 4: 65
Student 5: 88
