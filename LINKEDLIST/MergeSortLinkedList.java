public class MergeSortLinkedList 
{
    public static class Node 
    {
        int data;
        Node next;

        Node(int data)
        {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head = null;
    public static Node tail = null;
    public static int size = 0;

    public Node mergeSort(Node head)
    {
        if(head == null || head.next == null)
        {
            return head;
        }

        Node middle = getMiddle(head);

        Node nextOfMiddle = middle.next;
        middle.next = null;

        Node left = mergeSort(head);

        Node right = mergeSort(nextOfMiddle);

        Node sortedList = sortedMerge(left, right);

        return sortedList;
    }


    public static Node sortedMerge(Node left, Node right)
    {
        Node result = null;

        if(left == null)
        {
            return right;
        }

        if(right == null)
        {
            return left;
        }

        if(left.data <= right.data)
        {
            result = left;
            result.next = sortedMerge(left.next, right);
        }

        else
        {
            result = right;
            result.next = sortedMerge(left, right.next);
        }

        return result;
    }
    public static Node getMiddle(Node head)
    {
        if(head == null)
        {
            return head;
        }
        Node slow = head;
        Node fast = head;

        while(fast.next != null && fast.next.next != null)
        {
            slow= slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    static void push(int data)
    {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;

    }
    public static void print(Node head)
    {
        while(head != null) 
        {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }



    public static void main(String[] args) 
    {
        MergeSortLinkedList ll = new MergeSortLinkedList();
        
        ll.push(15);
        ll.push(10);
        ll.push(5);
        ll.push(20);
        ll.push(3);
        ll.push(2);
        // System.out.println(ll.head.data);
        ll.head = ll.mergeSort(ll.head);
        System.out.println("\n sorted linked list is : \n");
        ll.print(ll.head);

    }
    
}