package com.Solution.String;

import java.util.HashMap;

/*
题目：请实现一个函数用来找出字符流中第一个只出现一次的字符。例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 */
/*
思路：用HashMap存储字符出现的次数
 */
public class FIRSTAppearingOnce {
    StringBuilder s=new StringBuilder();
    HashMap<Character,Integer> map=new HashMap<>();
    //Insert one char from stringstream
    public void Insert(char ch)
    {
            s.append(ch);
        if(map.get(ch)==null)
            map.put(ch,1);
        else{
            int value=map.get(ch);
            map.put(ch,value+1);
        }
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        for (int i = 0; i < s.length(); i++) {
            if(map.get(s.charAt(i))==1)
                return s.charAt(i);
        }
        return '#';
    }
}
