package com.wf.msb.a08;

// 最大重合线段
public class A01MaxLine {

    public static void main(String[] args) {

        System.out.println((0-1)/2);


    }


    static class Line  implements Comparable<Line>{
        private Integer start;
        private Integer end;


        @Override
        public int compareTo(Line o) {
            return this.start- o.start;
        }
    }
}
