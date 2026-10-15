import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class PhoneDirectory {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, String> contacts = new LinkedHashMap<>();
        int choice;

        do {
            System.out.println("\n1. Add  2. Search  3. Update  4. Display  5. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            if (choice == 1) {
                System.out.print("Enter name: ");
                String name = sc.next();
                System.out.print("Enter phone number: ");
                String phone = sc.next();
                contacts.put(name, phone);
                System.out.println("Contact added.");
            } else if (choice == 2) {
                System.out.print("Enter name to search: ");
                String name = sc.next();
                if (contacts.containsKey(name)) {
                    System.out.println(name + " : " + contacts.get(name));
                } else {
                    System.out.println("Contact not found.");
                }
            } else if (choice == 3) {
                System.out.print("Enter name to update: ");
                String name = sc.next();
                if (contacts.containsKey(name)) {
                    System.out.print("Enter new phone number: ");
                    contacts.put(name, sc.next());
                    System.out.println("Phone number updated.");
                } else {
                    System.out.println("Contact not found.");
                }
            } else if (choice == 4) {
                for (Map.Entry<String, String> e : contacts.entrySet()) {
                    System.out.println(e.getKey() + " : " + e.getValue());
                }
            }
        } while (choice != 5);
        System.out.println("Exiting...");
    }
}

Input/Output
  1. Add  2. Search  3. Update  4. Display  5. Exit
Enter choice: 1
Enter name: siddu
Enter phone number: 9398369837
Contact added.

1. Add  2. Search  3. Update  4. Display  5. Exit
Enter choice: 1
Enter name: shiva
Enter phone number: 9984763768
Contact added.

1. Add  2. Search  3. Update  4. Display  5. Exit
Enter choice: 2
Enter name to search: siddu
siddu : 9398369837

1. Add  2. Search  3. Update  4. Display  5. Exit
Enter choice: 3
Enter name to update: siddu
Enter new phone number: 9987866547
Phone number updated.

1. Add  2. Search  3. Update  4. Display  5. Exit
Enter choice: 4
siddu : 9987866547
shiva : 9984763768
