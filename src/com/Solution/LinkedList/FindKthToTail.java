package com.Solution.LinkedList;

public class FindKthToTail {
	
	
	
	    public static ListNode Solution(ListNode head,int k) {
	        ListNode node1=head;
	        ListNode node2=head;
	        
	        int i=0;
	        for (;node1!=null;i++){
	        	node1=node1.next;
	        	if(i>=k)
	        		node2=node2.next;
	        }
	        return (i<k)?null:node2;
//	        for(int i=1;i<=k-1;i++){
//	            node1=node1.next;            
//	        }
//	        while(node1.next!=null)
//	        {
//	            node1=node1.next;
//	            node2=node2.next;
//	        }
//	        return node2;
	    }
	    
	    public static void main(String[] args) {
	    	ListNode head=new ListNode(1);
	    	ListNode node=head;
	    	for(int i=2;i<10;i++)
	    	{
	    		node.next=new ListNode(i);
	    		node=node.next;
	    	}
			ListNode resuleListNode=FindKthToTail.Solution(head,1);
			System.out.println(resuleListNode);
		}
	}

 class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
    @Override
	public String toString() {
		// TODO Auto-generated method stub
		return "ListNode:value="+this.val;
	}
	
}
