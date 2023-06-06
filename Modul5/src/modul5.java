package Modul5;

import java.sql.Struct;
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

    void inorder(Node node){
        if (node != null){
            inorder(node.left);
            System.out.println(node.data + " ");
            inorder(node.right);
        }
    }


    void preorder(Node node){
        if (node != null){
            System.out.println(node.data + " ");
            preorder(node.left);
            preorder(node.right);
        }
    }

    void postorder(Node node){
        if (node != null) {
            postorder(node.left);
            postorder(node.right);
            System.out.println(node.data + " ");
        }
    }

    void drawTree(Node node, String prefix, boolean isLeft){
        if (node != null){
            drawTree(node.right, prefix + (isLeft? "│   " : "    "), false);
            System.out.println(prefix + (isLeft? "└── " : "┌── ") + node.data);
            drawTree(node.left, prefix + (isLeft? "    " : "│   "), true);
        }
    }

    void printTree(){
        drawTree(root, " ", true);
    }
}

public class modul5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input Kombinasi Elemen (Pisahkan Dengan Spasi) : ");
        String inputCombination = scanner.nextLine();
        String[] elements = inputCombination.split(" ");

        BinaryTree binaryTree = new BinaryTree();
        for (String element : elements){
            binaryTree.insert(element);
        }

        System.out.println("\nBinary Tree : ");
        binaryTree.printTree();

        System.out.println("\nPre-order : ");
        binaryTree.preorder(binaryTree.root);
        System.out.println("\nIn-Order : ");
        binaryTree.inorder(binaryTree.root);
        System.out.println("\nPost-Order : ");
        binaryTree.postorder(binaryTree.root);
    }
}