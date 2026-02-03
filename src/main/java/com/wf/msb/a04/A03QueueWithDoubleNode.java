package com.wf.msb.a04;


/*
*
* 双向链表实现队列 和双端队列， 主要是操作 两个节点
*
* 双向链表 主要是就是 头节点 和 尾节点 的操作
*
*
* */
public class A03QueueWithDoubleNode {

    public static void main(String[] args) {
        Queue queue   = new Queue();
        queue.add(1);
        queue.add(2);
        queue.add(3);

        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        queue.add(4);
        System.out.println(queue.remove());
        System.out.println(queue.remove());


        Stack stack =new Stack();
        stack.add(1);
        stack.add(2);
        stack.add(3);
        System.out.println(stack.remove());
        System.out.println(stack.remove());
        System.out.println(stack.remove());
        System.out.println(stack.remove());
        stack.add(4);
        System.out.println(stack.remove());

    }



      // 先进后出
    static class Stack {

        private DoubleNode header;
        private DoubleNode tail;


        public  void add( int value){

            if(header == null){
                DoubleNode doubleNode = new DoubleNode(value);
                header = doubleNode;
                tail = doubleNode;
            }else{
                DoubleNode doubleNode = new DoubleNode(value);
                tail.next = doubleNode;
                doubleNode.pre=tail;
                tail = doubleNode;
            }
        }

        public int remove(){
            if(header == null){
                return 0;
            }else{
                if(header == tail){
                    int value = tail.value;
                    header = tail = null;
                    return value;
                }
                int value = tail.value;
                DoubleNode pre = tail.pre;
                pre.next = null;
                tail = pre;
                return value;
            }
        }
    }



    static class Queue{

        private DoubleNode header;
        private DoubleNode tail;

        public  void add(int value){
            if(header == null){
                DoubleNode doubleNode = new DoubleNode(value);
                tail = header = doubleNode;
            }else{
                DoubleNode doubleNode = new DoubleNode(value);
                tail.next = doubleNode;
                doubleNode.pre  = tail;
                tail = doubleNode;
            }
        }

        public  int remove(){

            if(header==null){
                return 0;
            }

            int value = header.value;

            if(tail == header){
                tail = header = null;
                return value;
            }

            DoubleNode next = header.next;
            next.pre = null;
            header = next;

            return value;
        }

    }
}
