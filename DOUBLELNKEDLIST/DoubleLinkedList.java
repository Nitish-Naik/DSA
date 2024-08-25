package LinkedList;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Stack;

public class DoubleLinkedList {
    // Inner Node class
    static class Node {
        int data;
        Node next;
        Node prev;

        public Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    // Doubly linked list class
    static class dll {
        Node head;
        Node tail;

        public dll() {
            this.head = null;
            this.tail = null;
        }

        // Add a node at the front of the list
        public void addFirst(int data) {
            Node nn = new Node(data);
            if (head == null) {
                head = tail = nn;
            } else {
                nn.next = head;
                head.prev = nn;
                head = nn;
            }
        }

        // Add a node at the end of the list
        public void addLast(int data) {
            Node nn = new Node(data);
            if (head == null) {
                head = tail = nn;
            } else {
                tail.next = nn;
                nn.prev = tail;
                tail = nn;
            }
        }

        // Delete the first node
        public void deleteFirst() {
            if (head == null) {
                System.out.println("List is empty");
                return;
            }
            if (head == tail) {
                head = tail = null;
            } else {
                head = head.next;
                head.prev = null;
            }
        }

        // Delete the last node
        public void deleteLast() {
            if (head == null) {
                System.out.println("List is empty");
                return;
            }
            if (head == tail) {
                head = tail = null;
            } else {
                tail = tail.prev;
                tail.next = null;
            }
        }

        // Insert node at a specific position
        public void insertAtPosition(int data, int position) {
            if (position < 1 || head == null) {
                System.out.println("Invalid position or empty list");
                return;
            }

            if (position == 1) {
                addFirst(data);
                return;
            }
            Node curr = head;
            for (int i = 1; i < position - 1; i++) {
                if (curr == null) {
                    System.out.println("Position out of bounds");
                    return;
                }
                curr = curr.next;
            }

            Node nn = new Node(data);
            nn.next = curr.next;
            if (curr.next != null) {
                curr.next.prev = nn;
            }
            curr.next = nn;
            nn.prev = curr;

            if (nn.next == null) {
                tail = nn;
            }
        }

        // Delete node at a specific position
        public void deleteAtPosition(int position) {
            if (head == null || position < 1) {
                System.out.println("Invalid position or empty list");
                return;
            }

            if (position == 1) {
                deleteFirst();
                return;
            }

            Node curr = head;
            for (int i = 1; i < position; i++) {
                curr = curr.next;
                if (curr == null) {
                    System.out.println("Position out of bounds");
                    return;
                }
            }

            if (curr.prev != null) {
                curr.prev.next = curr.next;
            } else {
                head = curr.next;
            }

            if (curr.next != null) {
                curr.next.prev = curr.prev;
            } else {
                tail = curr.prev;
            }
        }

        // Get the length of the list
        public int length() {
            Node curr = head;
            int count = 0;
            while (curr != null) {
                count++;
                curr = curr.next;
            }
            return count;
        }

        // Display the list from the head to the tail
        public void displayForward(PrintWriter op) {
            Node curr = head;
            while (curr != null) {
                op.print(curr.data + " ");
                curr = curr.next;
            }
            op.println();
        }

        // Display the list from the tail to the head
        public void displayBackward(PrintWriter op) {
            Node curr = tail;
            while (curr != null) {
                op.print(curr.data + " ");
                curr = curr.prev;
            }
            op.println();
        }

        // Check if the list is empty
        public boolean isEmpty() {
            return head == null;
        }

        // Find a node with specific data
        public void find(int data, PrintWriter op) {
            Node curr = head;
            if (head == null) {
                op.println("Empty List");
                return;
            }

            int position = 1;
            while (curr != null) {
                if (curr.data == data) {
                    op.println("Found at position: " + position);
                    return;
                }
                position++;
                curr = curr.next;
            }
            op.println("Data not found in the list");
        }

        // Reverse the doubly linked list
        public void reverseDLL(PrintWriter op) {
            Stack<Integer> stack = new Stack<>();
            Node curr = head;

            // Push all node data to stack
            while (curr != null) {
                stack.push(curr.data);
                curr = curr.next;
            }

            // Pop all data from stack and assign to nodes
            curr = head;
            while (curr != null) {
                curr.data = stack.pop();
                curr = curr.next;
            }

            op.println("Reversed List:");
            displayForward(op);
        }



        public void reverseDLL2(PrintWriter op) {
            Node curr = head;
            Node last = null;
            while(curr != null) {
                last = curr.prev;
                curr.prev = curr.next;
                curr.next = last;
                curr = curr.prev;
            }
            head = last.prev;
            // op.println("Reversed List : ");
            displayForward(op);
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        File inputFile = new File("input.txt");
        File outputFile = new File("output.txt");
        try (Scanner ip = new Scanner(inputFile); PrintWriter op = new PrintWriter(outputFile)) {
            int x = ip.nextInt();
            dll ll = new dll();
            int[] a = new int[x];

            for (int i = 0; i < x; i++) {
                a[i] = ip.nextInt();
            }

            for (int i : a) {
                ll.addFirst(i);
            }

            ll.addLast(9);

            op.println("List in forward order:");
            ll.displayForward(op);

            // op.println("List in backward order:");
            // ll.displayBackward(op);

            // op.println("List after first deletion:");
            // ll.deleteFirst();
            // ll.displayForward(op);

            // op.println("List after last deletion:");
            // ll.deleteLast();
            // ll.displayForward(op);

            // ll.insertAtPosition(100, 3);
            // op.println("List after insertion at position 3:");
            // ll.displayForward(op);

            // op.println("List after deletion at position 2:");
            // ll.deleteAtPosition(2);
            // ll.displayForward(op);

            // op.println("Length: " + ll.length());
            // op.println("Is empty: " + ll.isEmpty());

            // op.println("Find data 2:");
            // ll.find(2, op);

            // op.println("Reversing the DLL:");
            // ll.reverseDLL(op);


            op.println("Reversing the DLL:");
            ll.reverseDLL2(op);
        }
    }
}
