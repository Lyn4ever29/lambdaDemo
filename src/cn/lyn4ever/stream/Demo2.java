package cn.lyn4ever.stream;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 需求：
 * 从10万名学生中取出成绩在60分以上的男生(sex = 1)
 */
public class Demo2 {

    public static void main(String[] args) {

        //1.随机生成一系列学生成绩
        List<Student> list = new ArrayList<>();
        for (int i = 0; i < 1000000; i++) {
            list.add(new Student("stu" + i, (int) (Math.random() * 100), (int) (Math.random() * 2)));
        }
        for (int j = 0; j < 100; j++) {
            //使用常规操作
            List<Student> stus1 = getQualifiedStu1(list);

            //使用Stream流操作
            List<Student> stus2 = getQualifiedStu2(list);

//        检验一下这操作返回的结果是否相同
            for (int i = 0; i < stus1.size(); i++) {
                if (!stus1.get(i).equals(stus2.get(i))) {
                    System.out.println("这两个操作的结果不一致");
                    break;
                }
            }
        }
    }

    /**
     * 使用Stream流获取
     *
     * @param list
     * @return
     */
    private static List<Student> getQualifiedStu2(List<Student> list) {
        long s = System.currentTimeMillis();

        List<Student> list1 = list.stream().filter(stu -> stu.getSex() == 1)
                .filter(stu -> stu.getScore() >= 60)
                .collect(Collectors.toList());


        long e = System.currentTimeMillis();
        System.out.println("使用Stream操作的耗时是：" + (e - s) + "ms");
        wirteToFile(e-s,"stream");
        return list1;
    }

    private static List<Student> getQualifiedStu1(final List<Student> list) {
        long s = System.currentTimeMillis();

        List<Student> list1 = new ArrayList<>();

        //这里为什么使用迭代器？因为，迭代器的性能要比普通for循环和增强for快一点儿
        Iterator<Student> iterator = list.iterator();
        while (iterator.hasNext()) {
            Student stu = iterator.next();
            if (stu.getScore() >= 60 && stu.getSex() == 1) {
                list1.add(stu);
            }
        }


        long e = System.currentTimeMillis();
        System.out.println("使用常规操作的耗时是：" + (e - s) + "ms");
        wirteToFile(e-s,"normal");
        return list1;
    }


    private static void wirteToFile(long time, String file) {
        try (Writer writer = new BufferedWriter(new FileWriter("d://" + file + ".txt",true))) {
            writer.write(String.valueOf(time));
            writer.write("\n");
            writer.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
