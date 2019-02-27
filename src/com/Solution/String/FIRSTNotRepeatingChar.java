package com.Solution.String;

import java.util.HashMap;

/**
 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置, 如果没有则返回 -1（需要区分大小写）.
 * 思路1：构建哈希表，第一次遍历字符数组，存入字符(key)以及次数(value)；第二次遍历哈希表，取出次数
 */
public class FIRSTNotRepeatingChar {
//    /**
//     * 思路一
//     * @param str
//     * @return
//     */
//    public int FirstNotRepeatingChar(String str) {
//        if(str.length()==0||str==null)
//            return -1;
//        HashMap<Character,Integer> hashMap=new HashMap<>();
//        //存入字符及出现次数
//         for (int i = 0; i < str.length(); i++) {
//            if(hashMap.get(str.charAt(i))!=null)
//            {
//                int value=hashMap.get(str.charAt(i));
//                hashMap.put(str.charAt(i),value+1);
//            }
//            else
//                hashMap.put(str.charAt(i),1);
//        }
//        //取出次数
//        for (int j = 0; j < str.length(); j++) {
//            if(hashMap.get(str.charAt(j))==1)
//                return j;
//        }
//        return -1;
//    }

    /**
     * 思路2：用数组代替hash表
     * @param str
     * @return
     */
    public int FirstNotRepeatingChar(String str) {
        int len = str.length();
        if(len == 0)
            return -1;
        char [] s = str.toCharArray();
        int [] m = new int[256];
        for(int i = 0; i < len; i++){
            System.out.println(s[i]);
            m[s[i]]++;
        }
        for(int i = 0; i < len; i++){
            if(m[s[i]] == 1)
                return i;
        }
        return -1;
    }
    public static void main(String[] args) {
        String str="google";
        int ans=new FIRSTNotRepeatingChar().FirstNotRepeatingChar(str);
        System.out.println(ans);
    }
}
