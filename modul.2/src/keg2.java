public class keg2 {
    public static void main(String[] args) {
        keg2 list = new keg2();

        list.addNode(8);
        list.addNode(7);
        list.addNode(1);
        list.addNode(4);
        list.addNode(6);
        list.addNode(2);
        list.addNode(3);

        System.out.println("Before: ");
        list.printList();
        list.bubbleSort(list.head);

        System.out.println("After: ");
        list.printList();
    }

    Node head;
    Node tail;

    class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public void addNode(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public void printList() {
        Node current = head;

        if (head == null) {
            System.out.println("Tidak ada data");
            return;
        }
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void bubbleSort(Node start) {
        boolean swapped = true;
        Node node;
        Node tail = null;

        if (start == null) {
            return;
        }

        while (swapped) {
            swapped = false;
            node = start;

            while (node.next != tail) {
                if (node.data > node.next.data) {
                    int temp = node.data;
                    node.data = node.next.data;
                    node.next.data = temp;
                    swapped = true;
                }
                node = node.next;
            }
            tail = node;
        }
    }
}