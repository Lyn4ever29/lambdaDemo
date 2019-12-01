package cn.lyn4ever.lambda.myfun;

@FunctionalInterface
public interface MyFunction {

    /**
     * 定义一个获取字母大写的方法
     * @return
     */
    String getUpperCase(String letter);

}
