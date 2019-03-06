package com.Solution.Array;

/*题目：请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 */
/*
思路一：先判断数组是不是只有一位，如果只有一位则判读该位是不是数字0-9,不是则return false；如果不止一位再判断数组中是否包含'E'或‘e’,
不包含则判断数组是不是正负整数或者正负小数；包含则判读'E'或者‘e’的左半部分是不是正负整数或者正负小数，右半部分是不是正负整数。
 */
public class ISNumeric {
    public boolean isNumeric(char[] str) {
        if(str==null||str.length==0)
            return  false;
        int len=str.length;
        int end=len-1;
        boolean HasE=false;
        //位数为1则判读该位是不是数字0-9
        if(len==1)
            return  IsInt(str,0,end);
        int Eindex=0;
        //位数不为1则判断数组中是否包含'E'或‘e’
        for (; Eindex <len ; Eindex++) {
            if (str[Eindex] == 'E' || str[Eindex] == 'e') {
                HasE = true;
                break;
            }
        }
        //‘E'或’e‘在最后一位，返回false
        if(Eindex==len-1)
            return false;

        //不包含‘E'或’e‘，判断数组是不是正负整数或者正负小数
            if(!HasE){
                return IsSignedInt(str,0,end)||IsSignedFloat(str,0,end);
        }
            //包含则判读'E'或者‘e’的左半部分是不是正负整数或者正负小数，右半部分是不是正负整数
            else
            {
                return (IsSignedInt(str,0,Eindex-1)||IsSignedFloat(str,0,Eindex-1))&&IsSignedInt(str,Eindex+1,end);
            }


}

    private boolean IsInt(char[] c, int s, int e) {

        for (int i = s; i <= e; i++) {
            if (c[i] < '0' || c[i] > '9')
                return false;
        }
        return true;
    }

    private boolean IsSignedInt(char[] c,int s,int e)
    {
        if(s==e&&(c[s]<'0'||c[s]>'9'))
            return false;
        if(c[s]=='+'||c[s]=='-')
            return IsInt(c,s+1,e);
        return  IsInt(c,s,e);
    }

    private boolean IsFloat(char[] c, int s, int e) {

        int i = s;
        for (; i <= e; i++) {
            if ((c[i] < '0' || c[i] > '9')&&c[i] != '.')
                return false;
            if (c[i] == '.')
                break;
        }
        if(i==(e+1))
            return false;
        return IsInt(c, s, i - 1) && IsInt(c, i + 1, e);
    }
    private boolean IsSignedFloat(char[] c,int s,int e)
    {
        if(s==e&&(c[s]<'0'||c[s]>'9'))
            return false;
        if(c[s]=='+'||c[s]=='-'||c[s]=='.')
            return IsFloat(c,s+1,e);
        return  IsFloat(c,s,e);
    }

    public static void main(String[] args) {
        char[] s1="+100".toCharArray();
        char[] s2="5e2".toCharArray();
        char[] s3="-.123".toCharArray();
//        boolean ans1=new ISNumeric().isNumeric(s1);
//        boolean ans2=new ISNumeric().isNumeric(s2);
        boolean ans3=new ISNumeric().isNumeric(s3);
    }
}