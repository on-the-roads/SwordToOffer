package com.Solution.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。例如输入数组{3，32，321}，
 * 则打印出这三个数字能排成的最小数字为321323。
 *
 * 思路：定义自己的比较规则，数p和q，转为字符串拼接：如果pq<qp，则p<q;大于和等于号同理
 * 为了防止两个数字拼接后溢出，首先将整数数组转为字符串数组。
 */
public class PRINTMinNumber {
    public String PrintMinNumber(int [] numbers) {

        if(numbers==null||numbers.length==0)
            return new String();
        String[] str=new String[numbers.length];
        for (int i = 0; i < str.length; i++) {
            str[i]=String.valueOf(numbers[i]);
        }
        Arrays.sort(str, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String s1=o1+o2;
                String s2=o2+o1;
                return s1.compareTo(s2);
            }
        });

        StringBuffer stringBuffer=new StringBuffer();
        for (int i = 0; i < str.length; i++) {
            stringBuffer.append(str[i]);
        }
        return  stringBuffer.toString();
    }

    public static void main(String[] args) {
        int[] test={3,32,321};
        String ans=new PRINTMinNumber().PrintMinNumber(test);
        System.out.println(ans);
    }
}
