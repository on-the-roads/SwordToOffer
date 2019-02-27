package com.Solution.String;

/**
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 */
public class ReplaceSpace {
    public String replaceSpace(StringBuffer str) {
        if(str==null)
            return  null;
        StringBuffer newS=new StringBuffer();
        for (int i = 0; i <str.length(); i++) {
            if(str.charAt(i)==' '){
                newS.append("%20");
            }
            else {
                newS.append(str.charAt(i));
            }
        }
        return newS.toString();
    }

    public static void main(String[] args) {
       StringBuffer str=new StringBuffer("we are rice c c");
//      StringBuffer str=new StringBuffer(6);
       String s=new ReplaceSpace().replaceSpace(str);
        System.out.println(s);
    }
}
