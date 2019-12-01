package cn.lyn4ever.lambda;

public class TestMain2 {

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("这是一个线程:"+Thread.currentThread().getId());
            }
        }).start();


        new Thread(()->{
            System.out.println("这是一个线程:"+Thread.currentThread().getId());
        }).start();

    }

}
