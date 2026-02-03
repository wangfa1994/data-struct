package com.wf.msb.a08;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;



// 加强堆
public class A02AddHeap {

    public static void main(String[] args) {
        // 展示非基础类型的用法
        Student s1 = new Student(17, "A同学");
        Student s2 = new Student(10, "B同学");
        Student s3 = new Student(29, "C同学");
        Student s4 = new Student(33, "D同学");
        Student s5 = new Student(54, "E同学");
        Student s6 = new Student(93, "F同学");
        // 生成一个加强堆
        // 排序策略是年龄小的放在堆顶，年龄小根堆
        AddHeap<Student> heap1 = new AddHeap<>((a, b) -> a.age - b.age);
        // 把所有学生加入堆
        heap1.push(s1);
        heap1.push(s2);
        heap1.push(s3);
        heap1.push(s4);
        heap1.push(s5);
        heap1.push(s6);
        // 加入之后
        // 可以把某个同学的年龄改了
        // 比如把s5，也就是E同学
        // 年龄从54改成了4
        s5.age = 4;
        // 此时堆被破坏了，因为你擅自改了一个同学的年龄
        // 只需要调用resign方法，就能让堆恢复成年龄小根堆
        // 而且复杂度是O(log N)，很快的
        // 系统提供的堆做不到的，加强堆可以
        heap1.resign(s5);
        // 依次弹出所有学生
        // 会发现从年龄小到年龄大依次弹出
        // 说明堆是正确的
        while (!heap1.isEmpty()) {
            Student cur = heap1.pop();
            System.out.println("年龄 : " + cur.age + " , 名字 : " + cur.name);
        }

        System.out.println("======================");

        // 现在展示非基础类型的加强堆用法
        int[] arr = { 3, 3, 2, 5, 3 };
        // arr[0] == 3
        // arr[1] == 3
        // arr[2] == 2
        // arr[3] == 5
        // arr[4] == 3
        // 每个位置的数字一定会自带一个下标，这是一定的!
        // 任何基础类型的元素，天生一定会自带一些类似下标的身份信息的！这是一定的！
        // 生成一个加强堆
        // 加强堆里只放下标即可，因为通过下标可以找到数字
        // 排序策略是 :
        // 数字小的下标，在堆顶
        AddHeap<Integer> heap2 = new AddHeap<>((i, j) -> arr[i] - arr[j]);

        // 把数组所有的下标加入堆
        // 就等于加入了所有数字
        heap2.push(0);
        heap2.push(1);
        heap2.push(2);
        heap2.push(3);
        heap2.push(4);

        // 加入之后
        // 可以把某个下标上的数字改了
        // arr[1]原来是3，现在变成了-9
        arr[1] = -9;
        // 此时堆被破坏了，因为你擅自改了一个下标的数字
        // 只需要调用resign方法，就能让堆恢复
        // 而且复杂度是O(log N)，很快的
        // 系统提供的堆做不到的，加强堆可以
        // 调用resign方法
        heap2.resign(1);

        // 依次弹出所有下标
        // 会发现下标上的数字越小，下标越早弹出
        // 说明堆是正确的
        while (!heap2.isEmpty()) {
            int curIndex = heap2.pop();
            System.out.println("下标 : " + curIndex + " , 数字 :" + arr[curIndex]);
        }
    }

    // 一个自己定义的非基础类型
    public static class Student {
        public int age;
        public String name;

        public Student(int a, String n) {
            age = a;
            name = n;
        }
    }
}


class AddHeap<T>{
    private ArrayList<T> heap;
    private HashMap<T, Integer> indexMap; //反向索引表
    private int heapSize;
    private Comparator<? super T> comp;


    public AddHeap(Comparator<? super T> c) {
        heap = new ArrayList<>();
        indexMap = new HashMap<>();
        heapSize = 0;
        comp = c;
    }

    // 返回堆的大小
    public int getSize(){
        return heapSize;
    }

    // 判断是否是空的
    public boolean isEmpty(){
        return heapSize ==0;
    }

    // 判断是否包含某一个元素,这个是普通堆无法得到的
    public boolean containValue(T value){
        Integer integer = indexMap.get(value);
        return integer != null;
    }

    //
    public T peek(){
        T t = heap.get(0);
        return t;
    }

    public void push(T value){ // 这个就是heapInsert
        heap.add(value);
        indexMap.put(value, heapSize);  //需要先放入，直接就是正确的位置,heapInsert不进行交换的话，
        heapInsert(heap,heapSize++);
    }

    public T pop(){
        T t = heap.get(0);
        swap(0,heapSize-1);
        indexMap.remove(t);
        heap.remove(--heapSize);
        heapify(heap,0);
        return t;
    }

    // 移除指定的元素，这个堆是需要遍历的，加上反向索引表可以快速处理
    public void remove(T obj) {
        Integer index = indexMap.get(obj); //得到此对象的索引
        T replace = heap.get(heapSize - 1); // 得到最后值

        indexMap.remove(obj);
        heap.remove(--heapSize);
        if(obj!=replace){
            heap.set(index,replace);
            indexMap.put(replace,index);
            resign(obj);
        }

    }

    public void resign(T obj) {
        heapInsert(heap,indexMap.get(obj));
        heapify(heap,indexMap.get(obj));
    }




    public void heapInsert(ArrayList<T> array ,int index){

        // 小根堆
        while (comp.compare(array.get(index),array.get((index-1)/2)) < 0){
            swap(index,(index-1)/2);
            index = (index-1)/2;
        }

    }

    public void heapify(ArrayList<T> array , int index){
        int left = (2*index)+1;

        while (left<heapSize){

            int largest = left+1<heapSize && comp.compare(array.get(left),array.get(left+1))>0 ? left+1:left;

            largest = comp.compare(array.get(largest),array.get(index))<0?largest:index;

            if(largest == index){
                return;
            }
            swap(largest,index);
            index =largest;
            left = (2*index)+1;
        }

    }

    public  void swap(int a, int b){
        T aValue = heap.get(a);
        T bValue = heap.get(b);
        heap.set(a,bValue);
        heap.set(b,aValue);

        // 反向索引表也需要进行替换
        indexMap.put(aValue,b);
        indexMap.put(bValue,a);
    }


}

