package com.wf.msb.a10;

// 回文链表
public class A02Palindrome {

    static class Node {
        public int value;
        public Node next;

        public Node(int v) {
            value = v;
        }
    }


    // 1 2 3 4 5 6
    public static void main(String[] args) {

    }

    public static boolean check(Node head){

        Node midNode = partition(head);

        Node nextNode = midNode.next;
        midNode.next = null;

        Node t = null;
        while (nextNode!=null){
            Node temp = nextNode.next;
            Node temp1 = temp.next;
            temp.next = t;
            t = temp;

        }


        return false;
    }
    public static Node partition(Node head){
        Node slow = head;
        Node fast  = head;

        while (fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

}
