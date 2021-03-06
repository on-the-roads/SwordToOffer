package com.Solution.LinkedList;

/**
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 * 递归方法
 * @author Chenjiawen
 * 
 */
public class a2_Merge {
	public ListNode Merge(ListNode list1, ListNode list2) {
		if (list1 == null)
			return list2;
		else if (list2 == null)
			return list1;

		ListNode mergeHead = null;
		if (list1.val <= list2.val) {
			mergeHead = list1;
			list1=list1.next;
		}
		else {
			mergeHead=list2;
			list2=list2.next;
		}
		ListNode cur=mergeHead;
		while(list1!=null&&list2!=null)
		{
			if (list1.val <= list2.val) {
				cur.next = list1;
				list1=list1.next;
			}
			else {
				cur.next=list2;
				list2=list2.next;
			}
			cur=cur.next;
		}
		
		if(list1!=null){
			cur.next = list1;
			list1=list1.next;
			cur=cur.next;
		}
		if(list2!=null){
			cur.next=list2;
			list2=list2.next;
			cur=cur.next;
		}
		return mergeHead;
	}
	
	public static void main(String[] args) {
		ListNode head1=new ListNode(1);
    	ListNode node=head1;
    	for(int i=2;i<6;i++)
    	{
    		node.next=new ListNode(i);
    		node=node.next;
    	}
    	ListNode head2=new ListNode(4);
    	ListNode node2=head2;
    	for(int i=5;i<7;i++)
    	{
    		node2.next=new ListNode(i);
    		node2=node2.next;
    	}
		ListNode nodehead = new a2_Merge().Merge(head1, head2);
		while (nodehead != null) {
			System.out.println(nodehead);
			nodehead = nodehead.next;
		}
	}
}
