package com.it.cxi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MiGong {
    private static List<String> arr = new ArrayList<>();

    public static void main(String[] args) {
        //走迷宫
        String[][] source = {
                {"0", "x", "0", "0"},
                {"0", "1", "0", "0"},
                {"1", "0", "0", "y"},
                {"0", "0", "1", "0"},
        };
        //输出原始数据
        System.out.println("初始play界面：");
        for (int i = 0; i < source.length; i++) {
            for (int j = 0; j < source[i].length; j++) {
                System.out.print(source[i][j] + " ");
            }
            System.out.println();
        }
        //调用移动的方法 （0,0）为我们设置的起点
        move(0, 1, source);
        //对数组取值转置
        Collections.reverse(arr);
        System.out.println("最终结果为：" + arr);

        System.out.println("走过的路线图为：");
        for (int i = 0; i < source.length; i++) {
            for (int j = 0; j < source[i].length; j++) {
                System.out.print(source[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int move(int a, int b, String[][] source) {
        //移动的四个方向
        int ad = a + 1;         //下
        int ax = a - 1;         //上
        int bd = b + 1;         //右
        int bx = b - 1;         //左

        //判断是否满足边界条件
        if (ad < source.length) {
            //下  如果能走下一步接着调用移动方法
            if (source[ad][b] == "0" || source[ad][b] == "y") {
                //给走过的路线标记 * 号避免，刚走了下一步，到下一个点又执行向上
                source[a][b] = "*";
                //如果等于 1 表示找到出口 然后一直返回（触发递归的条件）
                if (move(ad, b, source) == 1) {
                    source[a][b] = "-";
                    arr.add(a + "," + b);
                    System.out.println(arr);
                    return 1;
                }
            }
        }
        if (ax >= 0) {
            //上
            if (source[ax][b] == "0" || source[ax][b] == "y") {
                source[a][b] = "*";
                if (move(ax, b, source) == 1) {
                    source[a][b] = "-";
                    arr.add(a + "," + b);
                    System.out.println(arr);
                    return 1;
                }
            }
        }
        if (bd < source[a].length) {
            //右
            if (source[a][bd] == "0" || source[a][bd] == "y") {
                source[a][b] = "*";
                if (move(a, bd, source) == 1) {
                    source[a][b] = "-";
                    arr.add(a + "," + b);
                    System.out.println(arr);
                    return 1;
                }
            }
        }
        if (bx >= 0) {
            //左
            if (source[a][bx] == "0" || source[a][bx] == "y") {
                source[a][b] = "*";
                if (move(a, bx, source) == 1) {
                    source[a][b] = "-";
                    arr.add(a + "," + b);
                    System.out.println(arr);
                    return 1;
                }
            }
        }
        source[a][b] = "*";
        //出口点
        if (a == 2 && b == 3) {
            System.out.println("有出口且走过的点的路径如下：");
            arr.add(a + "," + b);
            //输出成功的每个点
            System.out.println(arr);
            source[a][b] = "-";
            //返回 1 代表成功 0 失败
            return 1;
        }

        return 0;
    }
}


