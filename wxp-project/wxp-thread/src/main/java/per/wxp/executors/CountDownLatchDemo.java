package per.wxp.executors;



import java.util.concurrent.CountDownLatch;
import java.util.logging.Logger;

/**
 * 倒计时计数器
 * 一个任务，需要等待其他几个任务执行完成
 */
public class CountDownLatchDemo {
   static Logger logger= Logger.getLogger("CountDownLatchDemo");
    public static void main(String[] args) {
        final CountDownLatch lath=new CountDownLatch(2);
        //任务1
        new Thread(){
            @Override
            public void run() {
                try {
                    logger.info("任务1 正在执行");
                    Thread.sleep((long) (Math.random()*1000));
                    lath.countDown();
                    logger.info("任务1 执行完毕");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }.start();
        //任务2
        new Thread(){
            @Override
            public void run() {
                try {
                    logger.info("任务2 正在执行");
//                    Thread.sleep((long) (Math.random()*3000));
                    Thread.sleep(5000);
                    lath.countDown();
                    logger.info("任务2 执行完毕");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
        logger.info("等待其他两个任务执行完毕，主线程"+Thread.currentThread().getName());
        try {
            lath.await();
            logger.info("其他两个任务执行完毕，主线程执行任务"+Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
