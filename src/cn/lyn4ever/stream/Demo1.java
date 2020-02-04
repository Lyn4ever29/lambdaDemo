package cn.lyn4ever.stream;

import java.util.ArrayList;
import java.util.stream.Stream;

public class Demo1 {

    public static void main(String[] args) {
        ArrayList<Integer> arrList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            arrList.add((int) (Math.random() * 100));
        }

//        printValue1(arrList);
        printValue2(arrList);
    }

    /**
     * 使用Stream操作
     *
     * @param arrList
     */
    private static void printValue2(ArrayList<Integer> arrList) {
        arrList.stream().filter(i -> i > 60).forEach(System.out::println);
    }

    /**
     * 使用常规的遍历操作
     *
     * @param arrList
     */
    private static void printValue1(ArrayList<Integer> arrList) {
        for (Integer i : arrList) {
            if (i > 60) {
                System.out.printf("%d ", i);
            }
        }
    }

}
