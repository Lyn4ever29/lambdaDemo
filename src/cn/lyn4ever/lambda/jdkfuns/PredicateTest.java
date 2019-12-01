package cn.lyn4ever.lambda.jdkfuns;

import java.util.function.Predicate;

public class PredicateTest {
    public static void main(String[] args) {

        //定义一个功能，如果输入0,这返回true,其他的返回false
        Predicate<Integer> predicate = (Integer param) -> {
            if (null != param && param == 0)
                return true;
            return false;
        };

        //直接调用predicate中的test方法
        System.out.println(predicate.test(12));

    }

}
