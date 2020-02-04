package cn.lyn4ever.stream;

import java.util.function.Function;
import java.util.stream.Stream;

/**
 * Stream流的中间操作
 */
public class StreamOpe {


    public static void main(String[] args) {

        // 将集合中的字符串装换成大写形式
        Stream<String> stream0 = Stream.of("a", "b", "hello")
                .map(new Function<String, String>() {
                    @Override
                    public String apply(String s) {
                        return s.toUpperCase();
                    }
                });
        //上边的代码可以使用Lambda表达式简写为如下格式
        Stream<String> stream = Stream.of("a", "b", "hello")
                .map(s -> s.toUpperCase());



        Stream<String> stream1 = Stream.of("a", "abc", "abcdefg")
                .filter(value -> value.length() > 1);

        Stream<Integer> stream2 = Stream.of(1, 2)
                .flatMap(numbers -> Stream.of(5, 6, 7, 8));


        // 获取累加的值，reduce第一个参数是初始值
        Integer count = Stream.of(1, 2, 3)
                .reduce(0, (o1, o2) -> o1 + o2);
        System.out.println(count);//6
    }
}
