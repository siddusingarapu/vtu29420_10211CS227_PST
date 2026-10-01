import java.util.*;

// Product class
class Product {
    int id;
    String name;
    double price;

    Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    void display() {
        System.out.println(id + "  " + name + "  ₹" + price);
    }
}

// Order class
class Order {
    int orderId;
    int productId;
    int priority;

    Order(int orderId, int productId, int priority) {
        this.orderId = orderId;
        this.productId = productId;
        this.priority = priority;
    }
}

public class OnlineShoppingSystem {

    public static void main(String[] args) {

        // NON-LINEAR COLLECTION
        // HashMap stores products using Product ID as key
        HashMap<Integer, Product> products = new HashMap<>();

        products.put(101, new Product(101, "Laptop", 55000));
        products.put(102, new Product(102, "Mobile", 25000));
        products.put(103, new Product(103, "Headphones", 2000));
        products.put(104, new Product(104, "Keyboard", 1500));

        // Searching product by ID
        int searchId = 102;

        System.out.println("Product Search:");

        Product p = products.get(searchId);

        if (p != null) {
            p.display();
        } else {
            System.out.println("Product not found");
        }


        // LINEAR COLLECTION
        // ArrayList maintains a list of orders
        ArrayList<Order> orderList = new ArrayList<>();

        orderList.add(new Order(1, 101, 3));
        orderList.add(new Order(2, 103, 1));
        orderList.add(new Order(3, 102, 2));
        orderList.add(new Order(4, 104, 1));


        // NON-LINEAR COLLECTION
        // PriorityQueue processes orders according to priority
        PriorityQueue<Order> priorityQueue =
            new PriorityQueue<>(
                (a, b) -> Integer.compare(a.priority, b.priority)
            );

        // Add orders to PriorityQueue
        priorityQueue.addAll(orderList);

        System.out.println("\nOrders Processed According to Priority:");

        while (!priorityQueue.isEmpty()) {

            Order order = priorityQueue.poll();

            System.out.println(
                "Order ID: " + order.orderId +
                ", Product ID: " + order.productId +
                ", Priority: " + order.priority
            );
        }
    }
}



Input/Output
  Product Search:
102  Mobile  ?25000.0

Orders Processed According to Priority:
Order ID: 2, Product ID: 103, Priority: 1
Order ID: 4, Product ID: 104, Priority: 1
Order ID: 3, Product ID: 102, Priority: 2
Order ID: 1, Product ID: 101, Priority: 3
