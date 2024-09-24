package com.gxl.algorithm.hard;

/**
 * Test
 *
 * @author gxl
 * @version Id: 1.0.0
 * @since 2024/8/6 11:05
 */
public class Test {
    static String name = getName();

    static String getName() {
        System.out.println("静态字段");
        return "静态字段";
    }

    static {
        System.out.println("静态代码块");
    }

    String name2 = name2();

    String name2() {
        System.out.println("实例字段");
        return "实例字段";
    }

    Test() {
        System.out.println("构造函数");
    }

    {
        System.out.println("实例代码块");
    }

    public static void main(String[] args) {
        //new Test();
    }
}
