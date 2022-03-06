package com.aojia.practice.array;

/**
 * @author QiTian
 * @date 2022/3/6
 * @Description 题目59.螺旋矩阵II
 * 给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
 * 示例:
 * 输入: 3 输出: [ [ 1, 2, 3 ], [ 8, 9, 4 ], [ 7, 6, 5 ] ]
 * 模拟顺时针画矩阵的过程:
 * 填充上行从左到右
 * 填充右列从上到下
 * 填充下行从右到左
 * 填充左列从下到上    One Piece
 */
public class D {
    public static int[][] generateMatrix(int n) {
        int [][]matrix=new int[n][n];
        int num=1;
        int left=0,right=n-1,top=0,bottom=n-1;//定义边界
        while (num<=n*n){
            for (int i=left;i<=right;i++) matrix[top][i]=num++; //填充上行从左到右
            top++;//1
            for (int i=top;i<=bottom;i++) matrix[i][right]=num++; //填充右列从上到下
            right--;//1
            for (int i=right;i>=left;i--) matrix[bottom][i]=num++; //填充下行从右到左
            bottom--;//1
            for (int i=bottom;i>=top;i--) matrix[i][left]=num++; //填充左列从下到上
            left++;
        }
        return matrix;
    }

    public static void main(String[] args) {
        int n=3;
        int [][]matrix=generateMatrix(n);
        for (int i=0;i<matrix.length;i++){
            for (int j=0;j<matrix[0].length;j++){
                System.out.print(matrix[i][j]+"\t");
            }
            System.out.println();
        }
    }
}
