package com.wf.msb.a04;

/*
*  给定一个链表，和一个值，进行删除指定的值
* https://leetcode.cn/problems/shan-chu-lian-biao-de-jie-dian-lcof/description/
*
* */
public class A02DeleteNode {

    public static void main(String[] args) {
        Node head = new Node(1);
        Node first = new Node(2);
        Node second = new Node(3);
        Node third = new Node(2);
        Node four = new Node(4);
        Node five = new Node(5);
        Node six = new Node(2);
        head.next = first;
        first.next = second;
        second.next = third;
        third.next = four;
        four.next = five;
        five.next = six;

        Node node = removeNode(head, 2);
        System.out.println(node);

    }

    // 1---->2----->2---->1---->4----->3
    public static Node removeNode(Node head , int num){
        Node headNew  = null; Node pre = null;
        while (head != null){
            if (head.value == num) {
                head = head.next;
            }else{
               if(headNew == null){
                   Node next  = head.next;
                   head.next=null;
                   headNew = head;
                   pre = head;
                   head = next;
               }else{
                   Node next  = head.next;
                   head.next = null;
                   pre.next = head;
                   pre = head;
                   head = next;
               }
            }
        }


        return  headNew;
    }

    // 1---->2----->2---->1---->4----->3
    public static Node removeNode2(Node head , int num){

        while (head!=null){
            if (head.value != num) {
                break;
            }
            head = head.next;
        }
        // 此时head 第一个不等于num的值
        Node pre  =head;
        Node cur = head;

        while (cur!=null){
            if (cur.value == num) {
                pre.next = cur.next;
            }else {
                pre = cur;
            }
            cur = cur.next;
        }

        return head;
    }

}
