/**
 * 生成区间不重复随机数
 */
package com.shenhuanjie.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomNumUtil {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis(); //开始测试时间
        List<Integer> lst = randomNum(0, 9999);
        System.out.println("Array: " + lst.toString());
        System.out.println("Size: " + lst.size());
        long endTime = System.currentTimeMillis(); //获取结束时间
        System.out.println("Running Times： " + (endTime - startTime) + "ms");

    }

    /**
     * 首先生成一个不重复的数集（例如：0~9999），然后每次生成随机索引，
     * 并且与当前索引进行交换(swap)，最后返回目标List对象（也可用其他类型实现）;
     *
     * @param begin 区间开始
     * @param end   区间结束
     * @return 返回目标List
     */
    public static List<Integer> randomNum(int begin, int end) {
        Random rd = new Random();
        List<Integer> lst = new ArrayList<>();//存放有序数字集合
        for (int i = begin; i <= end; i++) {
            lst.add(i);
        }
        int count = 0;
        for (Integer element : lst) {
            int index = rd.nextInt(lst.size() - count) + count;//随机索引
            lst.set(count, lst.get(index));
            lst.set(index, element);
            count++;
        }
        return lst;
    }
}
