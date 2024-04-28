

public class DeleteMiddle {

    public static class Node {
        int data;
        Node next;
    
        Node(int d) {
            data = d;
            next = null;
        }
    }
    Node head;

    void deleteMiddle() {
        if (head == null || head.next == null) {
            head = null;
            return;
        }

        Node slowPtr = head;
        Node fastPtr = head;
        Node prev = null;

        while (fastPtr != null && fastPtr.next != null) {
            fastPtr = fastPtr.next.next;
            prev = slowPtr;
            slowPtr = slowPtr.next;
        }

        // Delete the middle node
        prev.next = slowPtr.next;
    }

    void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        DeleteMiddle list = new DeleteMiddle();
        list.head = new Node(1);
        list.head.next = new Node(2);
        list.head.next.next = new Node(3);
        list.head.next.next.next = new Node(4);
        list.head.next.next.next.next = new Node(5);
        list.head.next.next.next.next.next = new Node(6);

        System.out.println("Original linked list:");
        list.printList();

        list.deleteMiddle();
        System.out.println("Linked list after deleting middle element:");
        list.printList();
    }
}
