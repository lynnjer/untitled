import java.util.Random;
import java.util.*;
//求最短通路值
public class MinMatrixLen{

    //(宽度优先)获得矩阵的最短长度,时间复杂度为O(N*M)
    public static int GetMinMatrixLen(int[][]matrix)
    {
        if(matrix==null||matrix.length==0||matrix[0].length==0
                ||matrix[0][0]!=1||matrix[matrix.length-1][matrix[0].length-1]!=1)
        {
            return 0;
        }
        int res=0;
        //生成相同大小的矩阵，存储走过的路径长度
        int[][]map=new int[matrix.length][matrix[0].length];
        Queue<Integer>rQ=new LinkedList<Integer>();
        Queue<Integer>cQ=new LinkedList<Integer>();
        map[0][0]=1;
        rQ.add(0);
        cQ.add(0);
        int r=0;//只是起初始化的作用
        int c=0;
        while(!rQ.isEmpty())
        {
            r=rQ.poll();
            c=cQ.poll(); //弹出队列首部的位置
            //遍历到最后一个位置
            if(r==matrix.length-1&&c==matrix[0].length-1)
            {
                return map[r][c];
            }
            walkTo(map[r][c],r-1,c,matrix,map,rQ,cQ); //up
            walkTo(map[r][c],r+1,c,matrix,map,rQ,cQ); //down
            walkTo(map[r][c],r,c-1,matrix,map,rQ,cQ); //left
            walkTo(map[r][c],r,c+1,matrix,map,rQ,cQ); //right

        }
        return res;

    }

    //走向某个位置
    /**
     pre  到(toR,toC)之前的最短路径
     matrix  原始矩阵
     map 存放位置的矩阵
     rQ  存放行坐标的队列
     cQ  存放列坐标的队列
     */
    public static void walkTo(int pre,int toR,int toC,int[][]matrix,int[][]map,Queue<Integer>rQ,Queue<Integer>cQ)
    {
        //越界，位置为0,已经走过，直接返回
        if(toR<0||toR==matrix.length||toC<0||toC==matrix[0].length
                ||matrix[toR][toC]!=1||map[toR][toC]!=0)
        {
            return;
        }
        map[toR][toC]=pre+1;

        //位置坐标加入两个队列
        rQ.add(toR);
        cQ.add(toC);

    }
//    //产生随机的矩阵
//    public static int[][]MakeMatrix(int row,int col)
//    {
//        Random ran=new Random();
//        int[][]matrix=new int[row][col];
//        for(int i=0;i<row;i++)
//        {
//            for(int j=0;j<col;j++)
//            {
//                matrix[i][j]=ran.nextInt(2);
//            }
//        }
//        return matrix;
//    }
//
//    //打印矩阵的内容
//    public static void PrintMatrix(int[][]matrix)
//    {
//        for(int i=0;i<matrix.length;i++)
//        {
//            for(int j=0;j<matrix[0].length;j++)
//            {
//                System.out.print(matrix[i][j]+" ");
//            }
//            System.out.println();
//        }
//    }
    public static void main(String[]args)
    {
//        //System.out.println("Hello");
//        int row=4;
//        int col=5;
//        int[][]matrix=MakeMatrix(row,col);
//        PrintMatrix(matrix);
//        //获得最短的路径
//        System.out.println(GetMinMatrixLen(matrix));

        int [][]matrix2={{1,0,1,1,1},
                {1,0,1,0,1},
                {1,1,1,0,1},
                {0,0,0,0,0}};

        System.out.println(GetMinMatrixLen(matrix2));
    }
}