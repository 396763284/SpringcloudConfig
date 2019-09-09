package per.wxp.executors;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 两个线程，同一个点（阻塞），交换数据
 *
 * 场景： 用于2个线程交换数据
 *       校对工作
 */
public class ExchangeDemo {

    public static void main(String[] args) {
        //交换器，交换两个用户
        final Exchanger<String> ec=new Exchanger<String>();
        ExecutorService threadPool= Executors.newCachedThreadPool();

        //张三团伙
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
               try {
                   String  returnStr=ec.exchange("人质");
                   System.out.println("绑架者 用人质交换==="+ returnStr);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        //人质
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep((long) (Math.random()*1000));
                    String  returnStr=ec.exchange("1000万");
                    System.out.println("人质用钱交换==="+ returnStr);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        threadPool.shutdown();
    }
}


