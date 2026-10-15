import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

class Product {
    int id;
    String name;
    int stock;
    double price;

    Product(int id, String name, int stock, double price) {
        this.id = id;
        this.name = name;
        this.stock = stock;
        this.price = price;
    }

    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Stock: " + stock + ", Price: " + price;
    }
}

public class ProductInventory {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<Integer, Product> inventory = new HashMap<>();

        System.out.print("Enter number of products: ");
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            System.out.print("Enter id, name, stock, price: ");
            int id = sc.nextInt();
            String name = sc.next();
            int stock = sc.nextInt();
            double price = sc.nextDouble();
            inventory.put(id, new Product(id, name, stock, price));
        }

        int choice;
        do {
            System.out.println("\n1. Sell product  2. Low stock  3. Sorted by stock  4. Find by ID  5. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            if (choice == 1) {
                System.out.print("Enter product id and quantity sold: ");
                int id = sc.nextInt();
                int qty = sc.nextInt();
                Product p = inventory.get(id);
                if (p == null) {
                    System.out.println("Product not found.");
                } else if (qty > p.stock) {
                    System.out.println("Not enough stock. Available: " + p.stock);
                } else {
                    p.stock = p.stock - qty;
                    System.out.println("Stock updated. Remaining: " + p.stock);
                }
            } else if (choice == 2) {
                System.out.print("Enter stock threshold: ");
                int limit = sc.nextInt();
                boolean found = false;
                for (Product p : inventory.values()) {
                    if (p.stock < limit) {
                        System.out.println(p);
                        found = true;
                    }
                }
                if (!found) {
                    System.out.println("No products below threshold.");
                }
            } else if (choice == 3) {
                List<Product> list = new ArrayList<>(inventory.values());
                Collections.sort(list, (a, b) -> a.stock != b.stock ? a.stock - b.stock : a.id - b.id);
                for (Product p : list) {
                    System.out.println(p);
                }
            } else if (choice == 4) {
                System.out.print("Enter product id: ");
                Product p = inventory.get(sc.nextInt());
                System.out.println(p == null ? "Product not found." : p);
            }
        } while (choice != 5);
        System.out.println("Exiting...");
    }
}

Input/Output
  Enter number of products: 4
Enter id, name, stock, price:  1 Pen 50 10.5
Enter id, name, stock, price: 2 Notebook 8 45.0
Enter id, name, stock, price:  3 Bag 15 599.0
Enter id, name, stock, price: 4 Marker 5 30.0

1. Sell product  2. Low stock  3. Sorted by stock  4. Find by ID  5. Exit
Enter choice: 1
Enter product id and quantity sold: 2 3
Stock updated. Remaining: 5

1. Sell product  2. Low stock  3. Sorted by stock  4. Find by ID  5. Exit
Enter choice: 1
Enter product id and quantity sold: 4 1
Stock updated. Remaining: 4

1. Sell product  2. Low stock  3. Sorted by stock  4. Find by ID  5. Exit
Enter choice: 2
Enter stock threshold: 10
ID: 2, Name: Notebook, Stock: 5, Price: 45.0
ID: 4, Name: Marker, Stock: 4, Price: 30.0

1. Sell product  2. Low stock  3. Sorted by stock  4. Find by ID  5. Exit
Enter choice: 3
ID: 4, Name: Marker, Stock: 4, Price: 30.0
ID: 2, Name: Notebook, Stock: 5, Price: 45.0
ID: 3, Name: Bag, Stock: 15, Price: 599.0
ID: 1, Name: Pen, Stock: 50, Price: 10.5

1. Sell product  2. Low stock  3. Sorted by stock  4. Find by ID  5. Exit
Enter choice: 4
Enter product id: 3
ID: 3, Name: Bag, Stock: 15, Price: 599.0

1. Sell product  2. Low stock  3. Sorted by stock  4. Find by ID  5. Exit
Enter choice: 5
Exiting...
