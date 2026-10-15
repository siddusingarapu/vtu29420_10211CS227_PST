import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

public class SecondLowestGrade {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        List<List<String>> students = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String name = sc.nextLine();
            String grade = sc.nextLine();
            List<String> record = new ArrayList<>();
            record.add(name);
            record.add(grade);
            students.add(record);
        }

        TreeSet<Double> grades = new TreeSet<>();
        for (List<String> record : students) {
            grades.add(Double.parseDouble(record.get(1)));
        }

        grades.pollFirst();
        double secondLowest = grades.first();

        List<String> names = new ArrayList<>();
        for (List<String> record : students) {
            if (Double.parseDouble(record.get(1)) == secondLowest) {
                names.add(record.get(0));
            }
        }

        Collections.sort(names);
        for (String name : names) {
            System.out.println(name);
        }
    }
}

Input/Output
  5
Harry
37.21
Berry
37.21
Tina
37.2
Akriti
41
Harsh
39

  Output
  Berry
Harry
