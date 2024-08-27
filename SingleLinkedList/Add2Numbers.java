
public class Add2Numbers {

    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head1 = null;
    public static Node head2 = null;

    public static void createList1(int data) {
        head1 = addToHead(head1, data);
    }

    public static void createList2(int data) {
        head2 = addToHead(head2, data);
    }

    private static Node addToHead(Node head, int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        return newNode;
    }

    public static Node add(Node head1, Node head2) {
        head1 = reverse(head1);
        head2 = reverse(head2);

        Node resultHead = null;
        int carry = 0;

        while (head1 != null || head2 != null || carry != 0) {
            int sum = carry;
            if (head1 != null) {
                sum += head1.data;
                head1 = head1.next;
            }
            if (head2 != null) {
                sum += head2.data;
                head2 = head2.next;
            }
            carry = sum / 10;
            resultHead = addToHead(resultHead, sum % 10);
        }

        return resultHead;
    }

    public static Node reverse(Node head) {
        Node prev = null;
        Node curr = head;
        Node nextNode;
        while (curr != null) {
            nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        return prev;
    }

    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        createList1(1);
        createList1(2);
        createList1(3);
        createList1(4);

        createList2(4);
        createList2(3);
        createList2(2);
        createList2(1);
        Node result = add(head1, head2);
        printList(result); 
    }
}
