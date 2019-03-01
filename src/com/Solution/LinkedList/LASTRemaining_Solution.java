package com.Solution.LinkedList;
//题目：圆圈中最后剩下的一个数
/*
    思路:构造环形链表
 */

public class LASTRemaining_Solution {
    class Node {
        int val;
        Node next;
        Node(int val) {
            this.val= val;
        }

    }

    public int LastRemaining_Solution(int n, int m) {
        if(n<1||m<1)
            return  -1;
        Node head=new Node(0);
        Node node=head;
        for (int i = 1; i <n ; i++) {
            node.next=new Node(i);
            node=node.next;
        }
        node.next=head;
        Node temp=head;
        node=head;
        for (int i = 0; i <n-1; i++) {
            for (int j = 1; j <m; j++) {
                temp=node;
                node=node.next;
            }
            temp.next=node.next;
            node=node.next;
        }
          return node.val;
    }

    public static void main(String[] args) {
        int ans=new LASTRemaining_Solution().LastRemaining_Solution(5,3);
    }
}
