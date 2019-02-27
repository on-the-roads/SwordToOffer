package com.Solution.LinkedList;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.junit.Test;

/**
 * 输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
 * 
 * 思路：通过栈实现
 */
public class PrintFromTailToHead {
	private class ListNode{
		Object Item;
		ListNode next;
		ListNode(Object item){
			this.Item=item;
			next=null;
		}
		
	}
	
	public  ArrayList<Object> execute(ListNode Node) {
		Stack<Object> stack=new Stack<Object>();
		ArrayList<Object> list=null;
		while(Node!=null){
			stack.push(Node.Item);
			Node=Node.next;
		}
		 list=new ArrayList<Object>();
		while(!stack.isEmpty()){
			list.add(stack.peek());
			stack.pop();
		}
		return list;
	}
	
	
	@Test
	public void testexecute() throws Exception {
		ListNode node1=new ListNode(1);
		ListNode node2=new ListNode(2);
		ListNode node3=new ListNode(3);
		ListNode node4=new ListNode(4);
		node4.next=node3;
		node3.next=node2;
		node2.next=node1;
		ListNode NodeList=node4;
		System.out.print("输入:");
		while(NodeList!=null)
		{
			System.out.print(NodeList.Item+"->");
			NodeList=NodeList.next;
		}
		System.out.println();
		ArrayList ResultList=execute(node4);
		System.out.print("输出:");
		for(Object i:ResultList){
			System.out.print(i.toString()+"->");
		}
	}
}
