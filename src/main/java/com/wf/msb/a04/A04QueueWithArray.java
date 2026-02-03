package com.wf.msb.a04;

/*
*
*  队列和栈的数组实现
*
* 栈数组实现 需要一个index进行控制即可
*
* 队列数组实现，这个需要进行 两个指针，而且这个数组，还是需要循环的，释放的空间要进行添加
*
* */
public class A04QueueWithArray {


    public static void main(String[] args) {


       /* Stack stack  = new Stack();
        stack.add(1);
        stack.add(2);
        stack.add(3);
        System.out.println(stack.remove());
        System.out.println(stack.remove());
        System.out.println(stack.remove());*/


        Queue queue = new Queue();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        System.out.println(queue.remove());
        queue.add(4);
        System.out.println(queue.remove());
        System.out.println(queue.remove());

    }


    static class Queue{
        private int[] content =new int[3];
        private int tailIndex;
        private int headerIndex;

        private int size;

        public void add(int i){
            if(size<content.length){

                content[tailIndex++] = i;
                size++;
                if(tailIndex >=content.length){
                    tailIndex = 0;
                }
            }else{
                System.out.println("满了放不进去:"+i);
            }
        }

        public int remove(){
            if(size>0){
                int i = content[headerIndex];
                headerIndex++;
                size--;
                if(headerIndex>= content.length){ //循环
                    headerIndex=0;
                }
                return i;
            }
            return -1;
        }


    }






    static class Stack{
        private int[] content =new int[32];

        private int tailIndex=0;


        public void  add(int value){
            content[tailIndex++] = value;
        }


        public int remove(){
            return content[--tailIndex];
        }



    }

}
