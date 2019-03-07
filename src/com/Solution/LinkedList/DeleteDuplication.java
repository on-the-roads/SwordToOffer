package com.Solution.LinkedList;

/*
 题目：在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 */
/*
 思路：设置三个指针，分别为head--指向PHead的上一个节点，first--指向当前确定不重复的节点，second--工作指针，一直往后面搜索
 */
public class DeleteDuplication {
    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null || pHead.next == null)
            return pHead;

        ListNode head = new ListNode(Integer.MIN_VALUE);
        head.next = pHead;
        ListNode first = head;
        ListNode second = first.next;
        while (second != null) {
            if ((second.next != null  && second.val == second.next.val)) {
                while (second.next != null && second != null && second.val == second.next.val)
                    second = second.next;
                first.next=second.next;
            }else
            {
                first=first.next;
            }
            second=second.next;
        }
    return head.next;

    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
//        head.next.next.next = new ListNode(2);
//        head.next.next.next.next = new ListNode(3);
//        head.next.next.next.next.next = new ListNode(3);
//        head.next.next.next.next.next.next = new ListNode(5);
        ListNode ans = new DeleteDuplication().deleteDuplication(head);
    }
}
