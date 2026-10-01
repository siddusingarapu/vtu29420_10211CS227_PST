import java.util.ArrayList;
import java.util.Scanner;

public class CommonSubjects {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Create lists for two students
        ArrayList<String> student1 = new ArrayList<>();
        ArrayList<String> student2 = new ArrayList<>();

        // Get subjects for Student 1
        System.out.print("Enter number of subjects for Student 1: ");
        int n1 = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n1; i++) {
            System.out.print("Enter subject " + (i + 1) + ": ");
            student1.add(sc.nextLine());
        }

        // Get subjects for Student 2
        System.out.print("\nEnter number of subjects for Student 2: ");
        int n2 = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n2; i++) {
            System.out.print("Enter subject " + (i + 1) + ": ");
            student2.add(sc.nextLine());
        }

        // Find common subjects
        student1.retainAll(student2);

        // Display common subjects
        System.out.println("\nCommon Subjects:");

        for (String subject : student1) {
            System.out.println(subject);
        }

        sc.close();
    }
}

Input/Output
  Enter number of subjects for Student 1: 5
Enter subject 1: telugu
Enter subject 2: hindi
Enter subject 3: english
Enter subject 4: maths
Enter subject 5: social

Enter number of subjects for Student 2: 5
Enter subject 1: hindi
Enter subject 2: maths
Enter subject 3: biology
Enter subject 4: social
Enter subject 5: economics

Common Subjects:
hindi
maths
social
