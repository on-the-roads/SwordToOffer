package com.Solution.LinkedList;

import java.util.Stack;


/**
 * 输入一个链表，反转链表后，输出新链表的表头。
 * 利用堆栈实现
 * 
 * @author Chenjiawen
 * 
 */

public class b2_ReverseList {
	public ListNode ReverseList(ListNode head) {
		if (head == null)
			return null;
	
		Stack<Integer> stack=new Stack<Integer>();
		while(head!=null){
			stack.push(head.val);
			head=head.next;
		}
		ListNode nodehead=new ListNode(stack.pop());
//		System.out.println(nodehead);
		ListNode node=nodehead;
		while(!stack.isEmpty()){
			node.next=new ListNode(stack.pop());
			node=node.next;
		}
		return nodehead;
	}

	public static void main(String[] args) {
		ListNode head=new ListNode(1);
    	ListNode node=head;
    	for(int i=2;i<10;i++)
    	{
    		node.next=new ListNode(i);
    		node=node.next;
    	}
//		while (head != null) {
//			System.out.println(head);
//			head = head.next;
//		}
		ListNode nodeHead = new b2_ReverseList().ReverseList(head);
		while (nodeHead != null) {
			System.out.println(nodeHead);
			nodeHead = nodeHead.next;
		}
	}
}