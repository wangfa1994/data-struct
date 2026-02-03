package com.wf.msb.a09;

import java.util.HashMap;

public class A01PreTree {

    private Node root;

    public A01PreTree() {
        this.root = new Node();
    }



    private void insert(String s){
        char[] charArray = s.toCharArray();
        Node node = this.root;
        node.pass++;

        for (int i = 0; i < charArray.length; i++) {
            char item = charArray[i];
            boolean exist = node.paths.containsKey(item);
            if(!exist){
                node.paths.put(item,new Node());
            }
            Node node1 = node.paths.get(item);
            node1.pass++;
            node = node1;
        }
        node.end++;
    }

    // word这个单词之前加如果几次
    public int search(String word){

        Node node = this.root;

        char[] charArray = word.toCharArray();

        for (int i = 0; i < charArray.length; i++) {
            char item = charArray[i];

            boolean exist = node.paths.containsKey(item);
            if(exist){
                node = node.paths.get(item);
            }else{
                return 0;
            }
        }
        return node.end;
    }

    // 所有加入字符串中，有几个是以pre这个字符串作为前缀的
    public int prefixNumber(String pre){

        Node node = root;
        char[] charArray = pre.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char item = charArray[i];

            boolean exist = node.paths.containsKey(item);
            if(exist){
                node = node.paths.get(item);
            }else{
                return 0;
            }
        }
        return  node.pass;
    }

    public void delete(String word){

        int check = search(word);
        if(check>0){
            char[] charArray = word.toCharArray();
            Node node = root;

            node.pass--;
            for (int i = 0; i < charArray.length; i++) {
                char item = charArray[i];
                node = node.paths.get(item);
                node.pass--;
                if(node.pass ==0){
                    node.paths.remove(item);
                    return;
                }
            }
        }
    }



    private void add(String s){

        char[] charArray = s.toCharArray();

        Node firstNode = this.root;
        firstNode.pass++;

        int cur = 0;
        while (cur< charArray.length){
            char item = charArray[cur];

            Node node = firstNode.paths.get(item);

            if(node == null){
                // 不存在，进行添加
                Node addNode = new Node();
                addNode.pass++;
                firstNode.paths.put(item,addNode);
                firstNode = addNode;
            }else{
                node.pass++;
                firstNode = node;

            }
            cur++;

        }
        firstNode.end++;
    }





    static class Node{

        private int pass;

        private int end;

        private HashMap<Character,Node> paths;


        public Node() {
            pass = 0;
            end = 0;
            paths = new HashMap<>();
        }

    }
}
