package per.wxp.executors;


import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *  线程 全部等待， 同时到达后执行
 *
 * 场景： 多线程计算数据，合并计算结果。
 *
 *
 *
 */
public class CyclicBarrierDemo {

    public static void main(String[] args) {
        // 参数 为 同时几个 线程
        final CyclicBarrier cb=new CyclicBarrier(3, new Runnable() {
            @Override
            public void run() {
                System.out.println("人员全部到，各自拍照");
                try {
                    Thread.sleep((long) (Math.random()*1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        ExecutorService threadPool= Executors.newCachedThreadPool();

//模拟 3个线程
        for (int i = 0 ; i < 3; i++) {
            final  int user=i+1;
            Runnable r=new Runnable() {
                @Override
                public void run() {

                    try {
                        //模拟每个人来到时间都不一样
                        Thread.sleep((long) (Math.random()*1000));
                        System.out.println(user+"号到达，当前有"+(cb.getNumberWaiting()+1));
                        // 阻塞
                        cb.await();
                        if(user==1){
                            System.out.println("拍照结束，人员全部到：开始吃饭.....");
                        }
                        Thread.sleep((long) (Math.random()*1000));

                        System.out.println(user+"吃完饭.....回家....");


                    } catch (InterruptedException |BrokenBarrierException e1) {
                        e1.printStackTrace();
                    }


                }
            };
            threadPool.execute(r);
        }
        threadPool.shutdown();

    }
}
