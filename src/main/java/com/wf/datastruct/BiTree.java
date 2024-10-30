package com.wf.datastruct;

public class BiTree {
    private char data;
    private BiTree leftChild;
    private BiTree rightChild;


    public static void printPre(BiTree biTree){
        if(biTree == null){
            return;
        }
        System.out.printf(biTree.getData()+"");
        printPre(biTree.getLeftChild());
        printPre(biTree.getRightChild());
    }

    public static void printMid(BiTree biTree){
        if(biTree == null){
            return;
        }
        printMid(biTree.getLeftChild());
        System.out.printf(biTree.getData()+"");
        printMid(biTree.getRightChild());
    }

    public static void printLast(BiTree biTree){
        if(biTree == null){
            return;
        }
        printLast(biTree.getLeftChild());
        printLast(biTree.getRightChild());
        System.out.printf(biTree.getData()+"");
    }

    public BiTree() {
    }

    public BiTree(char data) {
        this.data = data;
    }

    // 傻瓜式
    static  BiTree getBiTree() {
        BiTree Root = new BiTree('A');
        BiTree B = new BiTree('B');
        BiTree C = new BiTree('C');
        BiTree D = new BiTree('D');
        BiTree E = new BiTree('E');
        BiTree F = new BiTree('F');
        BiTree G = new BiTree('G');
        BiTree H = new BiTree('H');
        BiTree I = new BiTree('I');
        BiTree J = new BiTree('J');
        BiTree K = new BiTree('K');

        Root.setAllChild(B,C);
        B.setAllChild(D,E);
        C.setAllChild(F,G);
        D.setAllChild(H,null);
        E.setAllChild(null,null);
        F.setAllChild(I,null);
        G.setAllChild(null,J);
        H.setAllChild(null,K);
        I.setAllChild(null,null);
        J.setAllChild(null,null);
        K.setAllChild(null,null);
        return Root;
    }

    public void setAllChild(BiTree lChild,BiTree rChild) {
        this.leftChild = lChild;
        this.rightChild = rChild;
    }

    public char getData() {
        return data;
    }

    public void setData(char data) {
        this.data = data;
    }

    public BiTree getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(BiTree leftChild) {
        this.leftChild = leftChild;
    }

    public BiTree getRightChild() {
        return rightChild;
    }

    public void setRightChild(BiTree rightChild) {
        this.rightChild = rightChild;
    }



     static class BiTreeCreator{
        private  char[] data;
        private  int index;

         public BiTreeCreator(char[] data) {
             this.data = data;
         }

         public  BiTree createBiTreeWithPre(BiTree biTree){
            if(data.length<=index){
                return null;
            }
            char datum = data[index++];
            if('#' == datum){
                return null;
            }
            biTree.setData(datum);
            biTree.setLeftChild(createBiTreeWithPre(new BiTree()));
            biTree.setRightChild(createBiTreeWithPre(new BiTree()));
            return biTree;
        }

        public BiTree createBiTreeWithMid(BiTree biTree){
            if(data.length<=index){
                return null;
            }
            char datum = data[index];
            if('#' == datum){
                return null;
            }
            biTree.setLeftChild(createBiTreeWithMid(new BiTree()));
            biTree.setData(datum);
            biTree.setRightChild(createBiTreeWithMid(new BiTree()));
            return biTree;
        }

        public BiTree createBiTreeWithLast(BiTree biTree){
            if(data.length<=index){
                return null;
            }
            char datum = data[index];
            if('#' == datum){
                return null;
            }
            biTree.setLeftChild(createBiTreeWithLast(new BiTree()));
            biTree.setData(datum);
            biTree.setRightChild(createBiTreeWithLast(new BiTree()));
            return biTree;
        }

         public  BiTree createBiTreePre() {
             if (index >= data.length) return null;

             char ch = data[index++];

             if (ch == '#') {
                 return null;
             } else {
                 BiTree node = new BiTree(ch);
                 node.setLeftChild(createBiTreePre()); // 构造左子树
                 node.setRightChild(createBiTreePre()); // 构造右子树
                 return node;
             }
         }
         public  BiTree createBiTreeMid() {
             if (index >= data.length) return null;

             char ch = data[index++];

             if (ch == '#') {
                 return null;
             } else {
                 BiTree node = new BiTree();
                 node.setLeftChild(createBiTreePre()); // 构造左子树
                 node.setData(ch);
                 node.setRightChild(createBiTreePre()); // 构造右子树
                 return node;
             }
         }


         public char[] getData() {
             return data;
         }

         public void setData(char[] data) {
             this.data = data;
         }

         public int getIndex() {
             return index;
         }

         public void setIndex(int index) {
             this.index = index;
         }
     }


    public static void main(String[] args) {

       /* // 傻瓜式创建调用
        BiTree root = getBiTree();
        // ABDHKECFIGJ 前序遍历：先打印根节点值，然后打印左孩子，最后打印右孩子
        BiTree.printPre(root);
        System.out.println("==========");
        //HKDBEAIFCGJ 中序遍历：先打印左孩子，再打印根节点，最后打印右孩子
        BiTree.printMid(root);
        System.out.println("==========");
        //KHDEBIFJGCA 后续遍历：先打印左孩子，再打印右孩子，最后打印根节点
        BiTree.printLast(root);
        System.out.println("==========");*/

        // 补充对应的# 进行调用
        pre();
        //mid();





    }

    private static void pre() {
        String s = "ABDH#K###E##CFI###G#J##";
        char[] charArray = s.toCharArray();
        BiTreeCreator biTreeCreator = new BiTreeCreator(charArray);
        BiTree biTreeRoot = new BiTree();
        BiTree biTreeWithPre = biTreeCreator.createBiTreeWithPre(biTreeRoot);
        BiTree.printPre(biTreeWithPre);
        System.out.println("==========");
        biTreeCreator.setData(charArray);
        biTreeCreator.setIndex(0);
        BiTree biTreeRoot2 = biTreeCreator.createBiTreePre();
        BiTree.printPre(biTreeRoot2);
        System.out.println("==========");
    }
    private static void mid() {
        String s = "#HKD#BEAIF#CGJ";
        char[] charArray = s.toCharArray();
        BiTreeCreator biTreeCreator = new BiTreeCreator(charArray);
        BiTree biTreeRoot = new BiTree();
        BiTree biTreeWithPre = biTreeCreator.createBiTreeWithMid(biTreeRoot);
        BiTree.printMid(biTreeWithPre);
        System.out.println("==========");
        BiTree biTreeRoot2 = biTreeCreator.createBiTreeMid();
        BiTree.printMid(biTreeRoot2);
        System.out.println("==========");
    }

    private static void last() {
        String s = "ABDH#K###E##CFI###G#J##";
        char[] charArray = s.toCharArray();
        BiTreeCreator biTreeCreator = new BiTreeCreator(charArray);
        BiTree biTreeRoot = new BiTree();
        BiTree biTreeWithPre = biTreeCreator.createBiTreeWithPre(biTreeRoot);
        BiTree.printPre(biTreeWithPre);
        System.out.println("==========");
        BiTree biTreeRoot2 = biTreeCreator.createBiTreePre();
        BiTree.printPre(biTreeWithPre);
        System.out.println("==========");
    }

}
