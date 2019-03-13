package com.Solution.Others;

/**
 * 题目：地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，
 * 但是不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
 * 但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 *
 * 思路：回溯法：从(0,0)开始走，每成功走一步用一个flag数组标记当前位置为1，然后从当前位置往四个方向探索，
 * 返回1 + 4 个方向的探索值之和。
 */
public class MovingCount {
    public int movingCount(int threshold, int rows, int cols)
    {
        if(threshold<0||rows<0||cols<0)
            return 0;
        int[][] flags=new int[rows][cols];
        return count(threshold, rows, cols, 0, 0,flags);
    }

    private int count(int threshold,int rows,int cols,int r,int c,int[][] flags) {
        if(r<0||c<0||r>=rows||c>=cols||sum(r)+sum(c)>threshold||flags[r][c]==1)
            return 0;
        flags[r][c]=1;
        return 1+count(threshold,rows,cols,r+1,c,flags)
                +count(threshold,rows,cols,r,c+1,flags)
                +count(threshold,rows,cols,r-1,c,flags)
                +count(threshold,rows,cols,r,c-1,flags);
    }

    private int sum(int i)
    {
        int sum=0;
        while(i!=0)
        {
            sum+=i%10;
            i/=10;
        }
        return sum;
    }

    public static void main(String[] args) {
        int ans=new MovingCount().movingCount(2,3,3);
    }
}
