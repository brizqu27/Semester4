import java.util.Scanner;

class Node{
    String data;
    Node left, right;

    Node(String item){
        data = item;
        left = right = null;
    }
}

class BinaryTree {
    Node root;

    BinaryTree(){
        root = null;
    }

    void insert(String data){
        root = insertNode(root, data);
    }

    Node insertNode(Node root, String data){
        if (root == null){
            root = new Node(data);
            return root;
        }
        if (data.compareTo(root.data) < 0){
            root.left = insertNode(root.left, data);
        }else {
            root.right = insertNode(root.right, data);
        }

        return  root;
    }

    void inorderTraversal(Node node){
        if (node != null){
            inorderTraversal(node.left);
            System.out.print(node.data + " ");
            inorderTraversal(node.right);
        }
    }


    void preorderTraversal(Node node){
        if (node != null){
            System.out.print(node.data + " ");
            preorderTraversal(node.left);
            preorderTraversal(node.right);
        }
    }

    void postorderTraversal(Node node){
        if (node != null) {
            postorderTraversal(node.left);
            postorderTraversal(node.right);
            System.out.print(node.data + " ");
        }
    }

    void drawTree(Node node, String prefix, boolean isLeft){
        if (node != null){
            drawTree(node.right, prefix + (isLeft ? "│   " : "    "), false);
            System.out.println(prefix + (isLeft ? "└── " : "┌── ") + node.data);
            drawTree(node.left, prefix + (isLeft ? "    " : "│   "), true);
        }
    }

    void printTree(){
        drawTree(root, " ", true);
    }
}

public class modul5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input Combination Element : ");
        String inputCombination = scanner.nextLine();
        String[] elements = inputCombination.split(" ");

        BinaryTree binaryTree = new BinaryTree();
        for (String element : elements){
            binaryTree.insert(element);
        }

        System.out.println("\nBinary Tree : ");
        binaryTree.printTree();

        System.out.println("\nPre-order  : ");
        binaryTree.preorderTraversal(binaryTree.root);
        System.out.println("\nIn-Order   : ");
        binaryTree.inorderTraversal(binaryTree.root);
        System.out.println("\nPost-Order : ");
        binaryTree.postorderTraversal(binaryTree.root);
    }
}