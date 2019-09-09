package per.wxp.threads;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.logging.Logger;

/**
 * @description:
 * @author: 点岩喵
 * @date: 2019-08-07 18:52
 */
public class CreateDemo {

     static Logger logger = Logger.getLogger("CreateDemo");

     class MyThread extends Thread {
        public  void run (){
          logger.info("ThreadLife");
        }
    }


    class MyRunnable implements Runnable{
        @Override
        public void run() {
            logger.info("MyRunnable");
        }
    }

    class MyCallable implements Callable<String>{
        @Override
        public String call() throws Exception {
            return "MyCallable";
        }
    }

    public static void main(String[] args) throws InterruptedException {
        CreateDemo createDemo = new CreateDemo();

        CreateDemo.MyThread myThread= createDemo.new MyThread();
        myThread.start();

        Thread.sleep(1000);

        CreateDemo.MyRunnable myRunnable=createDemo.new MyRunnable();
        Thread thread1 = new Thread(myRunnable);
        thread1.start();

        Thread.sleep(1000);

        CreateDemo.MyCallable myCallable= createDemo.new MyCallable();
        FutureTask<String> oneTask = new FutureTask(myCallable);
        Thread thread2 = new Thread(oneTask);
        thread2.start();

        try {
            String call= oneTask.get();
            logger.info("返回的结果："+call);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
