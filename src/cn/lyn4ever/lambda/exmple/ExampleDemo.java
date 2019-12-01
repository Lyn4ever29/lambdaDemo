package cn.lyn4ever.lambda.exmple;

public class ExampleDemo {
    public static void main(String[] args) {

        NoResultNoParam noResultNoParam = () -> System.out.println("NoResultNoParam");
        noResultNoParam.test();

        NoResultHasParam noResultHasParam = (param) -> System.out.println(param);
        noResultHasParam.test("hello");

        HasResultHasParam hasResultHasParam = (x, y) -> {
            int z = x + y;
            return z;
        };
        //下边这个也可以,只有一个返回值时，不用写{}
        HasResultHasParam hasResultHasParam1 = (x, y) -> x + y;
        System.out.println(hasResultHasParam.test(1,2));
        System.out.println(hasResultHasParam1.test(10,20));

    }

}

interface NoResultNoParam {
    void test();
}

interface NoResultHasParam {
    void test(String param);
}

interface HasResultHasParam {
    int test(int x, int y);
}