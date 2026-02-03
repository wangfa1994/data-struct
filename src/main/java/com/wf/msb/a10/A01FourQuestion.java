package com.wf.msb.a10;

// 链表边界值的四个问题

/**
 * Code01_LinkedListMid
 * 问题一：输入链表头节点，奇数个数，返回唯一一个中点，偶数个数，返回上中点。
 * 问题二：输入链表头节点，奇数个数，返回唯一一个中点，偶数个数，返回下中点。
 * 问题三：输入链表头节点，奇数个数，返回唯一一个中点的前一个节点，偶数个数，返回上中点的前一个节点
 * 问题三：奇数个数，返回唯一一个中点的前一个节点，偶数个数，返回下中点的前一个节点
 * <p>
 * 无非就是头节点指向哪里
 */

public class A01FourQuestion {
    static class Node {
        public int value;
        public Node next;

        public Node(int v) {
            value = v;
        }
    }

    // 奇数返回中点，偶数返回上中点，快节点多一步，
    public static Node midOrUpMidNode(Node head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }
        // 链表有3个点或以上
        Node slow = head.next;
        Node fast = head.next.next;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }


    // 奇数返回中点，偶数返回下中点，都向前赶一步，
    public static Node midOrDownMidNode(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node slow = head.next;
        Node fast = head.next;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // 奇数返回中点，偶数返回上中点的前一个节点
    public static Node midOrUpMidPreNode(Node head) {
        if (head == null || head.next == null || head.next.next == null) {
            return null;
        }
        Node slow = head;
        Node fast = head.next.next;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // 奇数返回中点，偶数返回下中点的前一个节点
    public static Node midOrDownMidPreNode(Node head) {
        if (head == null || head.next == null) {
            return null;
        }
        if (head.next.next == null) {
            return head;
        }
        Node slow = head;
        Node fast = head.next;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }


    /**
     * 1 2 3 4 5 ---- 3
     * 1 2 3 4 ---- 2
     */

    public static Node midAndUp(Node head) {

        Node slow = head;
        Node fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }


    /**
     * 1 2 3 4 5 ---- 3
     * 1 2 3 4 ---- 3
     */
    public static Node midAndDown(Node head) {
        Node slow = head.next;
        Node fast = head.next;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }


    /**
     * 1 2 3 4 5 ---- 3
     * 1 2 3 4 ---- 1
     */

    public static Node midAndUpPre(Node head) {
        if (head == null || head.next == null || head.next.next == null) {
            return null; // 不足3个节点，没有前一个节点
        }

        Node slow = head;
        Node fast = head.next.next;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;

        }

        return slow;
    }


    /**
     * 1 2 3 4 5 ---- 3
     * 1 2 3 4 ---- 2
     */
    public static Node midAndDownPre(Node head) {
        Node slow = head.next;
        Node fast = head.next.next;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;

        }

        return slow;
    }

}
