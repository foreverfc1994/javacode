import java.util.ArrayList;
import java.util.Stack;

import util.ListNode;

public class 从尾到头打印链表 {
    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        if(listNode==null){
            return arr;
        }
        while (listNode.next!=null){
            arr.add(listNode.val);
            listNode = listNode.next;
        }
        arr.add(listNode.val);
        ArrayList<Integer> arr1 = new ArrayList<Integer>();
        for(int i=arr.size()-1;i>=0;i--){
            arr1.add(arr.get(i));
        }
        return arr1;
    }
    public static ArrayList<Integer> printListFromTailToHead1(ListNode listNode) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        if(listNode==null){
            return arr;
        }
        ListNode pre = null;
        ListNode next = null;
        while (listNode!=null){
            next = listNode;
            listNode=listNode.next;
            next.next=pre;
            pre = next;

        }

        while (next!=null){
            arr.add(next.val);

            next = next.next;
        }
        return arr;
    }
    public static ArrayList<Integer> printListFromTailToHead3(ListNode listNode) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        if(listNode==null){
            return arr;
        }
        Stack<Integer> s = new Stack<Integer>();
        while (listNode!=null){
            s.push(listNode.val);
            listNode = listNode.next;
        }
        while (!s.empty()){
            arr.add(s.pop());
        }
       return arr;
    }
    public static ArrayList<Integer> printListFromTailToHead4(ListNode listNode) {
        if (listNode == null) {
            return new ArrayList<>();
        }
        ArrayList<Integer> arr = printListFromTailToHead4(listNode.next);
        arr.add(listNode.val);
        System.out.println(arr);
        return arr;
    }
    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(10);
        ListNode c = new ListNode(100);
        ListNode d = new ListNode(1000);

        a.next=b;
        b.next=c;
        c.next=d;
        printListFromTailToHead4(a);

    }
}
