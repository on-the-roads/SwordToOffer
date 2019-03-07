package com.Solution.LinkedList;

import java.util.HashMap;

//题目：给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
//思路： 用HashMap存储ListNode节点
public class ENTRYNodeOfLoop {
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if(pHead==null)
            return null;
        HashMap<ListNode,Integer> map=new HashMap<>();
        ListNode node=pHead;
        while(node!=null){

            if(map.get(node)==null)
                map.put(node,1);
            node=node.next;
            if(map.get(node)!=null)
                return node;
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode node1=new ListNode(1);
        ListNode node2=new ListNode(2);
        ListNode node3=new ListNode(3);
        ListNode node4=new ListNode(4);
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node2;
        ListNode ans=new ENTRYNodeOfLoop().EntryNodeOfLoop(node1);
    }
}
