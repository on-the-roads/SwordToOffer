package com.Solution.Array;

//题目：翻转单词顺序，例如：I am a boy. -> boy. a am I
//思路1：转换为字符数组操作
//思路2：直接在字符串上操作  利用String的trim和split函数
public class REVERSESentence {
//    public String ReverseSentence(String str) {
//        //思路1:
//        if (str == null || str.length() == 0)
//            return str;
//        char[] chars = str.toCharArray();
//        int len = chars.length;
//        char[] ans = chars.clone();
//        //第一次整体翻转
//        ans = turn(ans, 0, len - 1);
//        int s = 0;
//        boolean flag=true;//判断初始的字符串中是否有空格，没有则不进行翻转。
//        //遇到空格，则进行单词的反转
//        for (int i = 0; i < len; i++) {
//            if (Character.isSpaceChar(ans[i])) {
//                ans = turn(ans, s, i - 1);
//                s = i+1;
//                flag=false;
//            }
//        }
//        if(flag)
//            return str;
//        //将原始字符串的第一个单词进行翻转
//        ans=turn(ans,s,len-1);
//        return String.valueOf(ans);
//    }

//    //翻转指定位置的字符数组
//    private char[] turn(char[] ans, int s, int e) {
//        char[] temp = ans.clone();
//        for (int i = 0; i <= e - s; i++) {
//            temp[e - i] = ans[s + i];
//        }
//        return temp;
//    }

    public String ReverseSentence(String str) {
        //思路2
        if(str.trim().length()==0)
            return str;
        String[] temp=str.split(" ");
        String ans="";
        for (int i = temp.length-1; i >=0 ; i--) {
            ans=ans+temp[i];
            if(i!=0)
                ans=ans+" ";
        }
        return ans;
    }
    public static void main(String[] args) {
        String test="Hello World!";
        String ans=new REVERSESentence().ReverseSentence(test);
    }
}
