package com.wf.msb.a04;

import java.util.ArrayList;

/*
 *  单链表 和 双链表 的反转
 *
 *  暴力求解 使用集合，数组
 *
 *  技巧求解，使用两个节点进行转换处理
 *
 * */
public class A01ReverseList {


    public static void main(String[] args) {
        Node head = new Node(1);
        Node first = new Node(2);
        Node second = new Node(3);
        head.next = first;
        first.next = second;

        Node reH = reverseNode(head);
        System.out.println(reH);


        DoubleNode doubleNodeHead = new DoubleNode(1);
        DoubleNode doubleNodeFirst = new DoubleNode(2);
        DoubleNode doubleNodeSecond = new DoubleNode(3);
        DoubleNode doubleNodeThird = new DoubleNode(4);

        doubleNodeHead.next = doubleNodeFirst;

        doubleNodeFirst.pre = doubleNodeHead;
        doubleNodeFirst.next=doubleNodeSecond;

        doubleNodeSecond.next = doubleNodeThird;
        doubleNodeSecond.pre = doubleNodeFirst;

        doubleNodeThird.pre=doubleNodeSecond;

        DoubleNode doubleNode = reverseDoubleNode(doubleNodeHead);
        System.out.println(doubleNode);

    }

    // 1-->2-->3
    private static Node reverseNode(Node head) {

        Node pre = null; // 这个变动的
        Node next = null;

        while (head != null) {

            next = head.next; // 先保存下一个循环的节点，用于循环
            head.next = pre;  // 进行节点操作
            pre = head;
            head = next;
        }


        return pre;
    }

    // null <---1 <----> 2 <----> 3 <----> 4 ----> null
    private static DoubleNode reverseDoubleNode(DoubleNode head) {

        DoubleNode pre = null;
        DoubleNode next = null;

        while (head != null) {
            next = head.next;
            head.next=pre;
            head.pre = next;
            pre = head;
            head = next;
        }


        return pre;
    }

    // 容器代码 暴力求解的
    public static Node testReverseLinkedList(Node head) {
        if (head == null) {
            return null;
        }
        ArrayList<Node> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        list.get(0).next = null;
        int N = list.size();
        for (int i = 1; i < N; i++) {
            list.get(i).next = list.get(i - 1);
        }
        return list.get(N - 1);
    }

    public static DoubleNode testReverseDoubleList(DoubleNode head) {
        if (head == null) {
            return null;
        }
        ArrayList<DoubleNode> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        list.get(0).next = null;
        DoubleNode pre = list.get(0);
        int N = list.size();
        for (int i = 1; i < N; i++) {
            DoubleNode cur = list.get(i);
            cur.pre = null;
            cur.next = pre;
            pre.pre = cur;
            pre = cur;
        }
        return list.get(N - 1);
    }

    // 对数器 进行大数据量比对






    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            value = data;
        }
    }

    public static class DoubleNode {
        public int value;
        public DoubleNode pre;
        public DoubleNode next;

        public DoubleNode(int data) {
            value = data;
        }
    }
}
