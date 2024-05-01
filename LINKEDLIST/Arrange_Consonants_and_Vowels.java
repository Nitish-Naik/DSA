public class Arrange_Consonants_and_Vowels 
{
    public static class Node {
        char val;
        Node next;
        


        public Node(char x) {
            this.val = x;
            this.next = null;
        }
    }
    
    public static Node head = null;


    public static Node rearrange(Node head)
    {
        if(head == null || head.next == null)
        {
            return head;
        }

        Node vowelHead = new Node('0');
        Node consonantHead = new Node('0');
        Node vowelTail = vowelHead;
        Node consonantTail = consonantHead;
        Node current = head;
        while(current != null) 
        {
            if("aeiou".indexOf(current.val) != -1)
            {
                vowelTail.next = current;
                vowelTail = current;
            }
            else
            {
                consonantTail.next = current;
                consonantTail = current;
            }
            current = current.next;
        }
        vowelTail.next = consonantHead.next;
        consonantTail.next = null;
        return vowelHead.next;
    }

    public static void print(Node head)
    {
        if(head == null)
        {
            System.out.print("null");
            return;
        }
        while(head != null) 
        {
            System.out.print(head.val + "->");    
            head = head.next;
        }
        System.out.print("null");
    }

    public static void main(String[] args) 
    {
        Arrange_Consonants_and_Vowels head = new Arrange_Consonants_and_Vowels();
        Node h = new Node('a');
        h.next = new Node('b');
        h.next.next = new Node('e');
        h.next.next.next = new Node('c');
        h.next.next.next.next = new Node('a');
        h.next.next.next.next.next = new Node('a');
        System.out.println("original list : ");
        rearrange(h);
        print(h);
    }
}
