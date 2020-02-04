package cn.lyn4ever.stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Stream流的最终操作
 */
public class StreamResultDemo {


    public static void main(String[] args) {
        List<Integer> list = Stream.of(1, 2)
                .collect(Collectors.toList());
        System.out.println(list);

        Stream.of(1, 2).forEach(i -> System.out.print(i));
        System.out.println();
        //上边格式可以使用静态方法引用的方法简化
        Stream.of(1, 2).forEach(System.out::print);
    }
}
