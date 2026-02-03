package com.wf.msb.a07;

public class A01Heap {

    public static void main(String[] args) {
        // 6,7,0,1,8=====>8,7,0,1,6

        MyHeap myHeap = new MyHeap();
        myHeap.add(6);
        myHeap.add(7);
        myHeap.add(0);
        myHeap.add(1);
        myHeap.add(8);
        System.out.println(myHeap);
    }


}

class MyHeap{
   private int[] content = new int[100];
   private int heapSize=0;


   public boolean add(int value){

       content[heapSize]=value;
       // 开始维持大根堆
       heapInsert(value,heapSize);
       heapSize++;

       return true;

   }

    private void heapInsert(int value,int position) {

       int parent = (position-1)/2;
       while (value>content[parent] ){
           swap(content,position,parent);

           position = parent;
           parent = (parent-1)/2;
       }
    }

    // 插入之后，比较和我父亲的关系，如果大就交换，一直比
    // 直到为0 ，或者比我父亲小终止
    private void heapInsert(int[] array,int index){
       while (array[index] > array[(index-1)/2]){
           swap(array,index,(index-1)/2);
           index = (index-1)/2;
        }

    }


    // 弹出根节点
    public int pop(){
       int value = content[0]; // 根节点肯定是最大的，
        swap(content,0,heapSize); // 将最后的一个值提取到头节点
        heapSize--; // 堆大小减一


        // 开始调整堆保持大跟堆性质，这次需要向下看，找到我孩子中最大的那个，和他比较，看看是否需要调整位置，然后接着向下看
        // 直到找不到子孩子，或者比我子孩子都没有我大

        heapify();

        return value;
    }

    private void heapify() {
        int index = 0;
        int leftChildren = 2*index+1;
        int rightChildren =2*index+2;
        while (index<heapSize){

            if(rightChildren<=heapSize){ // 左右都有孩子
                if(content[leftChildren]>content[rightChildren]){
                    // 得到最大的进行比较
                    if(content[index] < content[leftChildren]){
                        // 进行交换
                        swap(content,index,leftChildren);
                        index =leftChildren;
                        leftChildren = 2*index+1;
                        rightChildren =2*index+2;
                    }else{
                        break;
                    }

                }else{
                    // 得到最大的进行比较
                    if(content[index] < content[rightChildren]){
                        // 进行交换
                        swap(content,index,rightChildren);
                        index =rightChildren;
                        leftChildren = 2*index+1;
                        rightChildren =2*index+2;
                    }else{
                        break;
                    }
                }
            }
            // 只有左节点
            if(rightChildren>heapSize && leftChildren<=heapSize){
                if(content[index] < content[leftChildren]){
                    // 进行交换
                    swap(content,index,leftChildren);
                    index =leftChildren;
                    leftChildren = 2*index+1;
                    rightChildren =2*index+2;
                }else{
                    break;
                }
            }
            if(rightChildren>heapSize && leftChildren>heapSize){
                break;
            }
        }
    }

    private void heapify(int[] arr, int index, int heapSize) {

       int leftChildren = index*2+1;
       while (leftChildren < heapSize){

           // 选出最大的孩子
           int largest = leftChildren+1 < heapSize  && arr[leftChildren + 1] > arr[leftChildren] ? leftChildren+1 : leftChildren;

           // 最大的孩子和当前进行对比
           largest = arr[index]<arr[largest]?largest:index;
           if(largest == index){
               break;//相同或到头了
           }
           swap(arr,index,largest);

           index= largest;
           leftChildren = index *2+1;

       }

    }


    private static void swap(int[] array, int v1,int v2){
        int temp = array[v1];
        array[v1]=array[v2];
        array[v2]=temp;
    }

}
