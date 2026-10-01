import java.util.Stack;
import java.util.Scanner;

public class BrowserHistoryy {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Stack<String> history = new Stack<>();

        System.out.println("Enter visited pages (-1 to stop):");

        while (true) {
            String page = sc.nextLine();

            if (page.equals("-1")) {
                break;
            }

            history.push(page);
        }

        System.out.println("\nBrowser History:");
        System.out.println(history);

        // Ask user to press Enter for Back
        while (!history.isEmpty()) {

            System.out.println("\nPress ENTER to go BACK");
            System.out.println("Type 'exit' to stop:");

            String choice = sc.nextLine();

            if (choice.equalsIgnoreCase("exit")) {
                break;
            }

            String page = history.pop();

            System.out.println("Going back from: " + page);

            System.out.println("Remaining History:");
            System.out.println(history);
        }

        if (history.isEmpty()) {
            System.out.println("\nNo more browser history.");
        }

        sc.close();
    }
}


Input/Output
  Enter visited pages (-1 to stop):
google
Instagram
Facebook
Rapido
-1

Browser History:
[google, Instagram, Facebook, Rapido]

Press ENTER to go BACK
Type 'exit' to stop:

Going back from: Rapido
Remaining History:
[google, Instagram, Facebook]
