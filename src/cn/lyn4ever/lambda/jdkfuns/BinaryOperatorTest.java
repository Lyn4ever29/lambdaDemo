package cn.lyn4ever.lambda.jdkfuns;

import java.util.function.BinaryOperator;

public class BinaryOperatorTest {
    public static void main(String[] args) {

        BinaryOperator<Integer> binaryOperator = (Integer i, Integer j) -> {
            //返回两个数中较大的一个
            return i > j ? i : j;
        };

        System.out.println(binaryOperator.apply(12,13));
    }
}
