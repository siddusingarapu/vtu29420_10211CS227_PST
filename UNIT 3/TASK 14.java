import java.io.*;
import java.util.*;

public class Solution {static class Node {
        int value;
        int color;
        int depth;
        List<Node> children = new ArrayList<>();

        Node(int value, int color) {
            this.value = value;
            this.color = color;
        }
    }

    static int leafSum = 0;
    static long redProduct = 1;
    static int evenDepthSum = 0;
    static int greenLeafSum = 0;

    static final long MOD = 1000000007;

    static void dfs(Node node) {

        if (node.children.isEmpty()) {

            leafSum += node.value;

            if (node.color == 0) {
                redProduct = (redProduct * node.value) % MOD;
            }

            if (node.color == 1) {
                greenLeafSum += node.value;
            }

            return;
        }
        if (node.color == 0) {
            redProduct = (redProduct * node.value) % MOD;
        }

        if (node.depth % 2 == 0) {
            evenDepthSum += node.value;
        }

        for (Node child : node.children) {
            dfs(child);
        }
    }
    

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] values = new int[n];
        int[] colors = new int[n];

        // Read values
        for (int i = 0; i < n; i++) {
            values[i] = sc.nextInt();
        }

        // Read colors
        for (int i = 0; i < n; i++) {
            colors[i] = sc.nextInt();
        }

        // Create nodes
        Node[] nodes = new Node[n];

        for (int i = 0; i < n; i++) {
            nodes[i] = new Node(values[i], colors[i]);
        }

        // Build tree
        for (int i = 0; i < n - 1; i++) {

            int u = sc.nextInt() - 1;
            int v = sc.nextInt() - 1;

            nodes[u].children.add(nodes[v]);
        }

        // Root is node 1
        nodes[0].depth = 0;

        // Calculate depths
        setDepth(nodes[0]);

        // Visit tree
        dfs(nodes[0]);

        // Results
        System.out.println(leafSum);
        System.out.println(redProduct);
        System.out.println(Math.abs(evenDepthSum - greenLeafSum));

        sc.close();
    }

    static void setDepth(Node node) {

        for (Node child : node.children) {
            child.depth = node.depth + 1;
            setDepth(child);
        }
    }
}

Input/Output
  Input (stdin)
5
4 7 2 5 12
0 1 0 0 1
1 2
1 3
3 4
3 5
Your Output (stdout)
24
40
15
Expected Output
24
40
15
