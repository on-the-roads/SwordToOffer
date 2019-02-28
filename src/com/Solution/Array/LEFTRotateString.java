package com.Solution.Array;
//题目：左旋转字符串
public class LEFTRotateString {
    public String LeftRotateString(String str,int n) {
        if(str.trim().length()==0)
            return  str;
        String ans=str.substring(n)+str.substring(0,n);
        return ans;
    }

    public static void main(String[] args) {
        String test="hello";
        String ans=new LEFTRotateString().LeftRotateString(test,2);
    }
}
