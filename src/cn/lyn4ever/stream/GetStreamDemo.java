package cn.lyn4ever.stream;

import java.util.ArrayList;
import java.util.stream.Stream;

/**
 * 获取Stream流
 * <p>
 * 从其他对象转为Stream对象
 */
public class GetStreamDemo {

    public static void main(String[] args) {
        //从集合中获取流
        ArrayList<Student> list = new ArrayList<>();
        list.add(new Student("张三", 60));
        list.add(new Student("李四", 70));
        list.add(new Student("王五", 80));
        list.add(new Student("赵六", 90));

        Stream<Student> stream = list.stream();

        //从数组中获取流
        Integer[] iArr = {12, 14, 15, 15, 17, 19, 22};
        Stream<Integer> stream1 = Stream.of(iArr);

    }

}

