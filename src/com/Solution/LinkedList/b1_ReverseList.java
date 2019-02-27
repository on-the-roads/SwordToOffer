package com.Solution.LinkedList;


/**
 * 输入一个链表，反转链表后，输出新链表的表头。
 * 设置三个指针，head为当前节点，pre为当前节点的前一个节点，next为当前节点的下一个节点，需要pre和nextwhole的目的是让当前节点从pre->head->next1->next2变成pre<-head
 * next1->next2的过程中，用pre让节点反转所指方向，nextwhole节点保存next1节点防止链表断开
 * 
 * @author Chenjiawen
 * 
 */

public class b1_ReverseList {
	public ListNode ReverseList(ListNode head) {
		if (head == null)
			return null;
		ListNode pre = null;
		ListNode nextwhole = null;

		while (head != null) {
			nextwhole = head.next;
			head.next = pre;
			pre = head;
			head = nextwhole;
		}
		return pre;
	}

	public static void main(String[] args) {
		ListNode head=new ListNode(1);
    	ListNode node=head;
    	for(int i=2;i<10;i++)
    	{
    		node.next=new ListNode(i);
    		node=node.next;
    	}
		ListNode nodehead = new b1_ReverseList().ReverseList(head);
		while (nodehead != null) {
			System.out.println(nodehead);
			nodehead = nodehead.next;
		}
	}
}