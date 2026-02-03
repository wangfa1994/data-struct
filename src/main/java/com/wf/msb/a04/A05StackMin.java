package com.wf.msb.a04;

import java.util.Stack;

/**
 * 实现一个特殊的栈，在基本的功能上进行再扩展实现返回栈中最小元素的功能
 * push pop getMin 操作的时间复杂度是O(1)
 * 可以使用现成的栈结构
 *
 */
public class A05StackMin {

    public static void main(String[] args) {
        MyStack myStack = new MyStack();

        myStack.add(1);
        myStack.add(2);
        myStack.add(1);
        myStack.add(2);




    }


    public static class MyStack{
        private Stack<Integer> dataStack;
        private Stack<Integer> minStack;

        public void add(int i){
            dataStack.add(i);
            Integer peek = minStack.peek();
            if(i<peek){
                minStack.add(i);
            }else {
                minStack.add(peek);
            }
        }

        public void remove(){
            dataStack.pop();
            minStack.pop();
        }

        public int getMin(){
            return minStack.peek();
        }

    }
}
