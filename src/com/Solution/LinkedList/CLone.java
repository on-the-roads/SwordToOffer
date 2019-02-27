package com.Solution.LinkedList;

import java.util.Random;

class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
/**
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
 * 返回结果为复制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 */
public class CLone {
    public RandomListNode Clone(RandomListNode pHead)
    {
        if(pHead==null)
            return null;
        //在旧链表上创建新链表
        RandomListNode head1=pHead;

        while (head1!=null){
            RandomListNode node=new RandomListNode(head1.label);
            node.next=head1.next;
            head1.next=node;
            head1= node.next;
        }

        RandomListNode head2=pHead;
        //赋值random
        while(head2!=null)
        {
            RandomListNode node=head2.next;
            node.random=(head2.random==null)?null:head2.random.next;
            head2=node.next;
        }
        //拆分链表
        RandomListNode head3=pHead;
        RandomListNode chead=pHead.next;
        while(head3!=null)
        {
            RandomListNode node=head3.next;
            head3=node.next;//注意，此行代码要在下行代码的前面，因为下行代码要改变node.next
            node.next=(node.next==null)?null:node.next.next;
        }
        return  chead;
    }

    public static void main(String[] args) {

        RandomListNode listhead=new RandomListNode(1);
        RandomListNode chead=listhead;
//        for (int i = 2; i < 6; i++) {
//            chead.next=new RandomListNode(i);
//            chead=chead.next;
//        }
        RandomListNode list1=listhead;
        while(list1!=null)
        {
            System.out.print(list1.label+" ");
            list1=list1.next;
        }
        System.out.println();

        RandomListNode newlisthead=new CLone().Clone(listhead);
         list1=newlisthead;
        while(list1!=null)
        {
            System.out.print(list1.label+" ");
            list1=list1.next;
        }
    }
}
