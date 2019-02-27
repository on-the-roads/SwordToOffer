package com.Solution.StackandQuene;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。假设压入栈的所有数字均不相等。
 * 例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。
 * （注意：这两个序列的长度是相等的）
 *
 * 思路：将序列1的元素逐个压栈，判断栈顶元素与序列2的元素相等，相等则弹出，否则继续压栈。
 */
public class ISPopOrder {
    public boolean IsPopOrder(int[] pushA, int[] popA) {
        if (popA.length == 0 || pushA.length == 0 || popA.length != pushA.length)
            return false;
        int j = 0;
        Stack<Integer> stack = new Stack<>();
        for (int k = 0; k < pushA.length; k++) {
            stack.push(pushA[k]);
            while (!stack.isEmpty() && stack.peek() == popA[j]&&j<popA.length) {//判断栈顶元素是否与输出序列相等，相等则弹出。，否则继续压栈。
                stack.pop();
                j++;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        int[] pushA={1,2,3,4,5};
        int[] pushB={4,5,3,2,1};
        int[] pushC={4,3,5,1,2};
        ISPopOrder i=new ISPopOrder();
        boolean ans=i.IsPopOrder(pushA,pushC);
        System.out.println(ans);
    }
}