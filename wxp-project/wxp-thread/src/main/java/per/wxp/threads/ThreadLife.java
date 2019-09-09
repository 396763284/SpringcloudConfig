package per.wxp.threads;


import java.util.logging.Logger;

import static java.lang.Thread.MAX_PRIORITY;
import static java.lang.Thread.MIN_PRIORITY;
import static java.lang.Thread.NORM_PRIORITY;

/**
 * @description:
 * @author: 点岩喵
 * @date: 2019-08-07 19:10
 */
public class ThreadLife {

    Logger logger= Logger.getLogger("ThreadLife");

    class MyThread extends  Thread{
        private String name;
        public MyThread(String name, int pro){
            super();
            this.setPriority(pro);
            this.name=name;
        }
        public void run() {
            for (int i = 0; i < 10; i++) {
                logger.info("name:"+name+" 执行"+i);
            }

        }
    }


    public static void main(String[] args) {
        ThreadLife threadLife=new ThreadLife();
        MyThread thread1= threadLife.new MyThread("thread1",MAX_PRIORITY);
        MyThread thread2= threadLife.new MyThread("thread2",NORM_PRIORITY);
        MyThread thread3= threadLife.new MyThread("thread3",MIN_PRIORITY);

        thread1.start();
        try {
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread2.start();
        thread3.start();

    }
}
