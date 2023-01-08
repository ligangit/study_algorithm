package com.ligangit.stury.algorithm;

/**
 * 动态规划算法
 */
public class DynamicProgramming {


    public static void main(String[] args) {
        int[] value = {1000, 2500, 3000};
        int[] obj = {1, 3, 4};

        int[][] result = new int[4][5];

        int pack = 4;
        for (int i = 1; i <= obj.length; i++) {
            for (int j = 0; j <= pack; j++) {
                // 第一行和第一列的价值为0，不设置值
                if (j == 0) {
                    continue;
                }
                // 满足背包容量时才判断是否需要添加，否则就是不添加
                if (obj[i-1] <= j) {
                    //选择此物品 查询当前背包容量减去物品容量时的最大值，然后在加上当前背包的容量
                    int tem = result[i - 1][j - obj[i-1]] + value[i-1];

                    // 是选择此物品以及不选择此物品的最大值
                    result[i][j] = Math.max(result[i - 1][j], tem);
                } else {
                    // 如果容量不满足，就只能是上一次选择物品的数量
                    result[i][j] = result[i - 1][j];
                }


            }
        }

        // 输出最后一个数据，即最终结果
        System.out.println(result[3][4]);







    }



}
