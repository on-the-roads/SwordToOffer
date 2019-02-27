package com.Solution.LinkedList;

import java.util.Stack;

/**
 * 题目：输入两个链表，找出第一个共同结点
 */
/*
    思路：
    **空间换时间** 如果两个链表有相同的节点，由于是单向链表，所以从第一个共同节点起，后面节点全部相同，
    所以可以从末节点向头节点比较；此时就要利用堆栈将链表反转。
    时间度为O（m+n）,空间复杂度也为O（m+n）
    **遍历** 最容易想起的解法，时间复杂度为O（mn）
 */
public class FINDFirstCommonNode {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if(pHead1==null||pHead2==null)
            return null;
        Stack<ListNode> stack1=new Stack<>();
        Stack<ListNode> stack2=new Stack<>();
        ListNode node1=pHead1;
        ListNode node2=pHead2;
        ListNode nodecommon=null;
        while (node1!=null)
        {
            stack1.push(node1);
            node1=node1.next;
        }
        while (node2!=null)
        {
            stack2.push(node2);
            node2=node2.next;
        }

        while (stack1.size()!=0&&stack2.size()!=0&&stack1.peek().val==stack2.peek().val){
            stack1.pop();
            nodecommon=stack2.pop();
        }
        return nodecommon;
    }

    public static void main(String[] args) {
        ListNode node1=new ListNode(1);
        node1.next=new ListNode(2);
        node1.next.next=new ListNode(3);
        ListNode node2=new ListNode(2);
        node2.next=new ListNode(3);
        ListNode ans=new FINDFirstCommonNode().FindFirstCommonNode(node1,node2);
        System.out.println(ans.val);
    }
}
