public class LinkedList {
    public static class Node 
    {
        int data;
        Node next;

        public Node(int data)
        {
            this.data=data;
            this.next = null;
        }
    }
    public static Node head;
    public static Node tail;
    public static int size = 0;

    static void addFirst(int data)
    {
        // step - 1 = create new node
        Node n = new Node(data);
        size++;
        if(head == null)
        {
            head =tail = n;
            // System.out.println("head == tail");
            return;
        }
        // step - 2 == newNode.next = head;
        n.next = head;
        // step - 3 == head = new node
        head = n;
    }
    public static void addLast(int data)
    {
        Node n = new Node(data);
        size++;
        if(head == null)
        {
            head = tail = n;
            return;
        }
        tail.next = n;
        tail = n;
    }
    public static void printLL()
    {
        if(head == null)
        {
            System.out.println("empty ll");
            return;
        }
        Node temp = head;
        while(temp.next != null)
        {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.print(temp.data +"->");
        System.out.print("null");
    }
    public static void addMiddle(int data, int index)
    {
        if(index == 0)
        {
            addFirst(data);
            size++;
            return;
        }
        Node n = new Node(data);
        Node temp = head;
        int i = 0;
        while(i < index-1)
        {
            temp = temp.next;
            i++;
        }
        // i = index-1; temp -> prev
        n.next = temp.next;
        temp.next = n;
        size++;
    }
    public static int removeFirst()
    {
        if(size == 0)
        {
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        }
        else if(size == 1)
        {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        int val = head.data;
        head = head.next;
        size--;
        return val;
    }


    public static int removeLast()
    {
        if(size == 0)
        {
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        }
        else if(size == 1)
        {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        Node temp = head;
        Node prev = null;
        while(temp.next != null) 
        {
            prev = temp;   
            temp = temp.next; 
        }
        int val = temp.data;
        prev.next = null;
        tail = prev;
        size--;
        return val;
    }

    public static int iterative_search(int key)
    {
        int pos = 0;
        Node temp = head;
        while(temp.next != null) 
        {
            if(temp.data == key)
            {
                return pos;
            }  
            temp = temp.next;
            pos++;  
        }
        return -1;
    }

    public static int helper(Node head, int key)
    {
        if(head == null)
        {
            return -1;
        }
        if(head.data == key)
        {
            return 0;
        }

        int idx = helper(head.next, key);
        if(idx == -1)
        {
            return -1;
        }
        return idx +1;
    }
    public static int recursive_search(int key)
    {
        return helper(head, key);
    }

    public static void reverse()
    {
        Node prev = null;
        Node curr = tail = head;
        Node nextNode;
        while(curr != null) 
        {
            nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        head = prev;
        printLL();
    }
    public static void deleteNthfromEnd1(int idx)
    {
        reverse();
        Node temp = head;
        int i=0;
        if(idx == 0)
        {
            removeFirst();
            return;
        }
        Node prev = null;
        while(i <= idx-1) 
        {
            prev = temp;
            temp = temp.next;    
            i++;
        }
        prev.next = temp.next;
    }

    public static void deleteNthfromEnd2(int idx)
    {
        // calculate size
        int sz = 0;
        Node temp = head;
        while(temp != null) 
        {
            temp = temp.next;
            sz++;    
        }

        if(idx == 0)
        {
            head = head.next; // remove first;
            return;
        }

        // size -n

        int i=1;
        int iToFind = sz-idx;
        Node prev = head;
        while(i < iToFind) 
        {
            prev = prev.next;
            i++;    
        }
        prev.next = prev.next.next;
        return;
    }

    // Slow - fast approach
    public static Node findMid(Node head)
    {
        Node slow = head; // +1
        Node fast = head; // +2 

        while (fast != null && fast.next != null)
        {
            slow = slow.next; // +1
            fast = fast.next.next; // +2
        }

        return slow; // slow is my midNode;
    }

    public boolean checkPalindrome()
    {
        if(head == null || head.next == null)
        {
            return true;
        }
        // step -1 find mid
        Node miNode = findMid(head);
        // step -2 reverse 2nd half
        Node prev = null;
        Node curr = miNode;
        Node next;
        while(curr != null) 
        {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        Node right = prev; // right half head
        Node left = head;


        // step -3 check left half and right half

        while(right != null) 
        {
            if(left.data != right.data)
            {
                return false;
            }    
            left =left.next;
            right = right.next;
        }

        return true;
    }

    public static void deleteMiddle()
    {
        int size = sizeLL() / 2;
        int i=0;
        Node prev=null;
        Node temp = head;
        while(i < size)
        {
            prev = temp;
            temp = temp.next;
            i++;
        }
        prev.next = temp.next;
        printLL();
    }

    public static int sizeLL()
    {
        Node temp = head;
        int size = 0;
        while(temp != null)
        {
            temp = temp.next;
            size++;    
        }
        return size;
    }
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.addFirst(6);
        ll.addFirst(2);
        ll.addFirst(1);
        ll.addFirst(7);
        ll.addFirst(4);
        ll.addFirst(3);
        ll.addFirst(1);
        ll.deleteMiddle();

    }
}