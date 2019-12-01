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

