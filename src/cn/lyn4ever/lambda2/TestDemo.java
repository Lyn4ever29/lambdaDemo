package cn.lyn4ever.lambda2;

public class TestDemo {

    public static void main(String[] args) {
//        //调用method方法，使用lambda传入一个匿名的manteacher类
//        method(context -> System.out.println(context));

        //这时使用的是静态方法调用
        method(Teacher::teach);
    }

    private static void method(ManTeacher manTeacher) {
        manTeacher.teacher("同学们早上好");
    }

}
