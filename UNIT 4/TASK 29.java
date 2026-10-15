import java.util.HashMap;
import java.util.Scanner;

class Student {
    int id;
    String name;
    int marks;

    Student(int id, String name, int marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }
}

public class StudentIndexing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        HashMap<Integer, Student> students = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int id = sc.nextInt();
            String name = sc.next();
            int marks = sc.nextInt();
            students.put(id, new Student(id, name, marks));
        }

        int q = sc.nextInt();
        for (int i = 0; i < q; i++) {
            int id = sc.nextInt();
            Student s = students.get(id);
            if (s == null) {
                System.out.println("Student ID " + id + " not found");
            } else {
                System.out.println("ID: " + s.id + ", Name: " + s.name + ", Marks: " + s.marks);
            }
        }
    }
}

Input/Output
  4
101 Asha 88
102 Ravi 76
103 Meena 92
104 Kiran 69
3
103
110

  Output
  ID: 103, Name: Meena, Marks: 92
Student ID 110 not found
101
ID: 101, Name: Asha, Marks: 88
