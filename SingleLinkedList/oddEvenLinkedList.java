import java.util.*;
class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
 
public class oddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null) return head;
        ArrayList<Integer> res = new ArrayList<>();
        ListNode temp = head;
        while(temp != null && temp.next != null) {
            res.add(temp.val);
            temp = temp.next.next;
        }
        if(size(head) % 2 != 0) {
            res.add(temp.val);
        }

        temp = head.next;
        while(temp != null && temp.next != null) {
            res.add(temp.val);
            temp = temp.next.next;
        }
        if(size(head) % 2 == 0) {
            res.add(temp.val);
        }


        temp = head;
        int i=0;
        while(temp.next != null) {
            temp.val = res.get(i);
            temp = temp.next;
            i++;
            // i++;
        }
        temp.val = res.get(res.size()-1);
        return head;
    }

    public static int size(ListNode head) {
        ListNode temp = head;

        int i= 0;
        while(temp != null) {
            i++;
            temp = temp.next;
        }

        return i;
    }
}