package com.Solution.Others;

/**
 * 求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,
 * 但是对于后面问题他就没辙了。ACMer希望你们帮帮他,并把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数（从1 到 n 中1出现的次数）。
 * 思路1：判断1到n的每个数的每个位是否包含1，通过求余和进位来确定
 * 思路2：判断1到n的每个数的每个位是否包含1，通过将1到n的数转换成字符串来判断（利用stringBuffer.append()和toString（）方法）
 */
public class NUMberOf1Between1AndN_Solution {
    /**
     * 思路3：利用归纳法--假设当前位为百位
     * 1.若百位为0，则百位上出现1的个数为：高位数*当前位，例如：2034 ->  2*100=200
     * 2.若百位为1，则百位上出现1的个数为：高位数*当前位+低位数+1，例如：2134 ->  2*100+34+1=235
     * 3.若百位为2~9，则百位上出现1的个数为：(高位数+1)*当前位，例如：2134 ->  2*100+100=300
     * 由归纳法得，当前位为其他位时同样适用上述公式。
     */

    public int NumberOf1Between1AndN_Solution(int n) {
        int before = 0, after = 0, cur = 0, ans = 0;
        int i = 1;
        while (i <=n) {
            before = n / (i * 10);
            cur = n / i % 10;
            after = n % i;
            if(cur==0)
                ans=ans+before*i;
            else if(cur==1)
                ans=ans+before*i+after+1;
            else
                ans=ans+(before+1)*i;
            i = i * 10;
        }
        return ans;
    }

    public static void main(String[] args) {
        int res=0;
        res=new NUMberOf1Between1AndN_Solution().NumberOf1Between1AndN_Solution(-11);
        System.out.println(res);
    }
}
