import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class SmartTrafficNavigationGraph {
    static HashMap<Integer, List<Integer>> graph = new HashMap<>();
    static HashSet<Integer> visited = new HashSet<>();

    static void dfs(int node) {
        visited.add(node);
        for (int next : graph.get(node)) {
            if (!visited.contains(next)) {
                dfs(next);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        int source = sc.nextInt();
        int destination = sc.nextInt();

        dfs(source);

        if (visited.contains(destination)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
Input/Output
  6 4
1 2
2 3
4 5
5 6
1 6
  Output
  NO
