import java.io.*;
import java.util.*;

public class Solution {

    static abstract class Tree {
        private int value;
        private int color;
        private int depth;

        public Tree(int value, int color, int depth) {
            this.value = value;
            this.color = color;
            this.depth = depth;
        }

        public int getValue() {
            return value;
        }

        public int getColor() {
            return color;
        }

        public int getDepth() {
            return depth;
        }

        public abstract void accept(TreeVis visitor);
    }

    static class TreeNode extends Tree {
        private List<Tree> children = new ArrayList<>();

        public TreeNode(int value, int color, int depth) {
            super(value, color, depth);
        }

        public void addChild(Tree child) {
            children.add(child);
        }

        public List<Tree> getChildren() {
            return children;
        }

        @Override
        public void accept(TreeVis visitor) {
            visitor.visitNode(this);

            for (Tree child : children) {
                child.accept(visitor);
            }
        }
    }

    static class TreeLeaf extends Tree {

        public TreeLeaf(int value, int color, int depth) {
            super(value, color, depth);
        }

        @Override
        public void accept(TreeVis visitor) {
            visitor.visitLeaf(this);
        }
    }

    static abstract class TreeVis {

        public abstract int getResult();

        public abstract void visitNode(TreeNode node);

        public abstract void visitLeaf(TreeLeaf leaf);
    }

    static class SumInLeavesVisitor extends TreeVis {

        private int result = 0;

        @Override
        public int getResult() {
            return result;
        }

        @Override
        public void visitNode(TreeNode node) {
        }

        @Override
        public void visitLeaf(TreeLeaf leaf) {
            result += leaf.getValue();
        }
    }

    static class ProductOfRedNodesVisitor extends TreeVis {

        private long result = 1;

        @Override
        public int getResult() {
            return (int) result;
        }

        @Override
        public void visitNode(TreeNode node) {
            if (node.getColor() == 0) {
                result = (result * node.getValue()) % 1000000007;
            }
        }

        @Override
        public void visitLeaf(TreeLeaf leaf) {
            if (leaf.getColor() == 0) {
                result = (result * leaf.getValue()) % 1000000007;
            }
        }
    }

    static class FancyVisitor extends TreeVis {

        private int evenDepthSum = 0;
        private int greenLeafSum = 0;

        @Override
        public int getResult() {
            return Math.abs(evenDepthSum - greenLeafSum);
        }

        @Override
        public void visitNode(TreeNode node) {
            if (node.getDepth() % 2 == 0) {
                evenDepthSum += node.getValue();
            }
        }

        @Override
        public void visitLeaf(TreeLeaf leaf) {
            if (leaf.getColor() == 1) {
                greenLeafSum += leaf.getValue();
            }
        }
    }

    public static Tree solve() {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] values = new int[n];
        int[] colors = new int[n];

        for (int i = 0; i < n; i++) {
            values[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            colors[i] = sc.nextInt();
        }

        int[][] edges = new int[n - 1][2];

        for (int i = 0; i < n - 1; i++) {
            edges[i][0] = sc.nextInt();
            edges[i][1] = sc.nextInt();
        }

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0] - 1;
            int v = edge[1] - 1;

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        return buildTree(0, -1, 0, values, colors, graph);
    }

    static Tree buildTree(
            int current,
            int parent,
            int depth,
            int[] values,
            int[] colors,
            List<List<Integer>> graph) {

        List<Integer> children = new ArrayList<>();

        for (int next : graph.get(current)) {
            if (next != parent) {
                children.add(next);
            }
        }

        if (children.isEmpty()) {
            return new TreeLeaf(
                    values[current],
                    colors[current],
                    depth
            );
        }

        TreeNode node = new TreeNode(
                values[current],
                colors[current],
                depth
        );

        for (int child : children) {
            node.addChild(
                    buildTree(
                            child,
                            current,
                            depth + 1,
                            values,
                            colors,
                            graph
                    )
            );
        }

        return node;
    }

    public static void main(String[] args) {

        Tree root = solve();

        TreeVis visitor1 = new SumInLeavesVisitor();
        TreeVis visitor2 = new ProductOfRedNodesVisitor();
        TreeVis visitor3 = new FancyVisitor();

        root.accept(visitor1);
        root.accept(visitor2);
        root.accept(visitor3);

        System.out.println(visitor1.getResult());
        System.out.println(visitor2.getResult());
        System.out.println(visitor3.getResult());
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
Expected Output
24
40
15
