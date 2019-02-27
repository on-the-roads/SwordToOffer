package com.Solution.StackandQuene;

import java.util.Stack;

//用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
//push操作在stack1进行，pop操作在说stack2进行。
//pop操作中，若stack2有元素，则继续弹出；否则将stack1元素依次弹出存入stack2中再进行弹出。
public class PopAndPush {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if(stack2.isEmpty()&&stack1.isEmpty())
            throw new RuntimeException("Quene is Empty!!!");
        if (!stack2.isEmpty())
            return stack2.pop();
        else
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            return stack2.pop();
    }

    public static void main(String[] args) {
        PopAndPush solution = new PopAndPush();
        solution.push(1);
        solution.push(2);
        solution.push(3);
        System.out.println(solution.pop());
        solution.push(6);
        System.out.println(solution.pop());
        System.out.println(solution.pop());
        System.out.println(solution.pop());
    }
}

