import java.util.Scanner;

class TreeNode {
    int data;
    TreeNode left, right;

    TreeNode(int data) {
        this.data = data;
    }
}

public class PreorderTraversal {
    static Scanner sc = new Scanner(System.in);

    static TreeNode createTree() {
        System.out.print("Enter node value (-1 for no node): ");
        int value = sc.nextInt();
        if (value == -1) {
            return null;
        }
        TreeNode node = new TreeNode(value);
        System.out.println("Left child of " + value + ":");
        node.left = createTree();
        System.out.println("Right child of " + value + ":");
        node.right = createTree();
        return node;
    }

    static void preorder(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + " ");
        preorder(node.left);
        preorder(node.right);
    }

    public static void main(String[] args) {
        System.out.println("Create the root:");
        TreeNode root = createTree();
        System.out.print("Preorder traversal: ");
        preorder(root);
        System.out.println();
    }
}

Input/Output

  Create the root:
Enter node value (-1 for no node): 1
Left child of 1:
Enter node value (-1 for no node): 2
Left child of 2:
Enter node value (-1 for no node): 4
Left child of 4:
Enter node value (-1 for no node): -1
Right child of 4:
Enter node value (-1 for no node): -1
Right child of 2:
Enter node value (-1 for no node): 5
Left child of 5:
Enter node value (-1 for no node): -1
Right child of 5:
Enter node value (-1 for no node): -1
Right child of 1:
Enter node value (-1 for no node): 3
Left child of 3:
Enter node value (-1 for no node): -1
Right child of 3:
Enter node value (-1 for no node): -1
Preorder traversal: 1 2 4 5 3 
