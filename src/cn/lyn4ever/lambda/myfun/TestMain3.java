package cn.lyn4ever.lambda.myfun;

public class TestMain3 {


    public static void main(String[] args) {
        //匿名内部类
        MyFunction myFunction = new MyFunction() {
            @Override
            public String getUpperCase(String letter) {
                //实现这个方法
                return letter.trim().toUpperCase();
            }
        };
        //然后调用方法
        System.out.println(myFunction.getUpperCase("this is MyFunctoinTest"));



        //lambda表达式
        MyFunction myFunction1 = (String letter)->{
            return letter.trim().toUpperCase();
        };

        //然后调用方法
        System.out.println(myFunction1.getUpperCase("this is MyFunctoinTest"));



    }
}
