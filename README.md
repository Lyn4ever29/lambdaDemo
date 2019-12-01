# jdk1.8中的lambda表达式学习笔记

### 一、引入一个例子
我们写一个多线程的例子,如下：采用实现Runable接口的方式
```java
package cn.lyn4ever.lambda;

public class TestMain1 {
    public static void main(String[] args) {
        //线程1
        MyThread myThread1 = new MyThread();
        Thread t1 = new Thread(myThread1);
        t1.start();

        //线程2
        MyThread myThread2 = new MyThread();
        Thread t2 = new Thread(myThread2);
        t2.start();
    }

}

/**
 * 我们先写一个类来实现Runable接口,为了方便直接写进了这个类中
 */
class MyThread implements Runnable {

    @Override
    public void run() {
        System.out.println("这是一个多线程:" + Thread.currentThread().getId());
    }
}
```
当然，没有任命毛病。觉得自己写个类外部类太麻烦，那就写一个匿名内部类
```java
package cn.lyn4ever.lambda;

public class TestMain2 {

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("这是一个线程:"+Thread.currentThread().getId());
            }
        }).start();
    }

}
```
这样还是不够简单，那就用lambda表达式好了.
```java
		new Thread(()->{
            System.out.println("这是一个线程:"+Thread.currentThread().getId());
        }).start();
```
是的，就这么一句。看一个结果

![](https://raw.githubusercontent.com/Lyn4ever29/img/master/picgo20191130153628.png)
 
### 二、函数式接口
所谓函数式接口，就是这个接口只有一个抽象方法，（可以包含静态方法和default方法，这是jdk1.8以后的特性），
自定义一个函数式接口的方法很简单，就是加了注解，编译器会帮我们检查代码合理性
```java
@FunctionalInterface
public interface MyFunction {

    /**
     * 定义一个获取字母大写的方法
     * @return
     */
    String getUpperCase(String letter);
    
}
```
然后简单地应用下我们这个接口
```java
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
```

![](https://raw.githubusercontent.com/Lyn4ever29/img/master/picgo20191130160122.png)

可以看到，我们定义的这个MyFunction接口并没有什么用，因为具体的实现是在匿名内部类中写的。
```java
java.lang.Runable
java.lang.Comparable
java.lang.Comparator
java.lang.FileFilter
...
```
在java.util.function包中还定义了大量的功能性函数式接口，我们可以直接使用，而不用自己再去创建接口了。比如以下
##### 1.java.util.Predicate<T> 接收一个对象T,返回一个boolean类型结果
```java
 //定义一个功能，如果输入0,这返回true,其他的返回false
        Predicate<Integer> predicate = (Integer param) -> {
            if (null != param && param == 0)
                return true;
            return false;
        };

        //直接调用predicate中的test方法
        System.out.println(predicate.test(12));
```
可以看一个Predicate的源代码

![](https://raw.githubusercontent.com/Lyn4ever29/img/master/picgo20191130160708.png)

代码的结果肯定是false，不用看了。这个接口就可以满足我们的需求，只要我们想要``` 接收一个对象T,返回一个boolean类型结果```这样的功能，完全不用单独定义方法，只要用这个类就可以了。
还有很多，就不举例子了，将它们的功能列举出来
```java
java.util.function.Comsumer<T> 传入对象T，只是运算，不返回结果 （大家都知道，类作为形参时是地址引入）
<R> java.util.function.Funtion<T> 传入对象T，返回对象R
<T> java.util.function.Supplier 不接收参数，提供T对象
<T> java.util.function.UnaryOperator<T> 接收参数对象T,返回结果对象T
<T> java.util.function.BinaryOperator<T,T> 接收两个T对象，返回一个T对象(下边有个例子)
```
```java
public static void main(String[] args) {
        
        BinaryOperator<Integer> binaryOperator = (Integer i, Integer j) -> {
            //返回两个数中较大的一个
            return i > j ? i : j;
        };

        System.out.println(binaryOperator.apply(12,13));//13
    }
```

### 三、Lambda表达式的基本语法
#### 1.基本语法
* 0.基本语法: 
```T r = new T { () -> {这里边是方法的具体实现}   };```
* 1.lambda表达式要和接口绑定，
* 2.如果表达式中方法的实现只有一条语句，可以不写{} 和 reutrn 关键字，否则必须要写(如果有返回值就要写reutrn,没有不用写)
* 3.如果接口中的方法有参数，在() 中参数的类型，可写可不写

看一个例子
```java
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
```














