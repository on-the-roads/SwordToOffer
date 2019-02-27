package com.Solution.StackandQuene;

import java.util.Stack;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 * 思路：设置两个栈，一个栈为数据栈：存入数据；一个栈为最小元素栈：存入最小元素
 * 例如：数据栈：2,2,2,1,4  对应最小元素栈：2,2,2,1,1
 */
public class StackDIY {
    Stack<Integer> s_data = new Stack<>();
    Stack<Integer> s_min = new Stack<>();

    public void push(int node) {
        s_data.push(node);
        if (s_min.isEmpty())
            s_min.push(node);
        else if (!s_min.isEmpty() && s_min.peek() > node) {
            s_min.push(node);
        } else
            s_min.push(s_min.peek());
    }

    private boolean IsEmpty() {
        return s_data.isEmpty();
    }

    public void pop() {
        if(!IsEmpty()) {
            s_min.pop();
            s_data.pop();
        }
    }

    public int top() {
        if(!IsEmpty())
            return s_data.peek();
        else
            throw  new StackOverflowError();
    }

    public int min() {
        if(!IsEmpty())
            return s_min.peek();
        else
            throw  new StackOverflowError();
    }

    public static void main(String[] args) {
        StackDIY s = new StackDIY();
        s.push(1);
        s.push(2);
        s.push(3);
        s.pop();
        s.pop();
        s.push(5);
        s.push(9);
        s.push(1);
    }
}
