package com.Solution.String;
import java.util.ArrayList;
import java.util.Collections;

/**
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串
 * abc,acb,bac,bca,cab和cba。
 *
 * 此题转不过来弯  需要再次查看编写
 */
public class PERmutation {
    ArrayList<String> list=new ArrayList<>();
    public ArrayList<String> Permutation(String str) {
        if(str==null)
            return  list;
        int len=str.length();
        PermuHelper(str.toCharArray(),0,len-1);
        Collections.sort(list);
        return list;
    }
    private void PermuHelper(char[] str, int start,int end)
    {
        if(start==end)
            list.add(String.valueOf(str));
        for(int j=start;j<=end;j++)
        {
            if(start!=j&&str[j]==str[start])
                continue;
            swap(str,start,j);
            PermuHelper(str,start+1,end);
            swap(str,start,j);
        }
    }

   private void swap(char[] str,int i, int j)
   {
       char temp=str[i];
       str[i]=str[j];
       str[j]=temp;
   }


    public static void main(String[] args) {
        String test="abc";
        ArrayList<String> ans=new PERmutation().Permutation(test);
        for(String s:ans)
            System.out.println(s);
    }
}
