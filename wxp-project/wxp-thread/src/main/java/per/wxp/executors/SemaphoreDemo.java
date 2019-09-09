package per.wxp.executors;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * 怎么控制并发数量 为2
 *
 * 应用场景： 1. 限流  2. 资源访问
 */
public class SemaphoreDemo {

    /**
     * 执行任务类，获取信号量和释放信号量
     */
    class SemaphoreRunnable implements Runnable{

        private Semaphore semaphore;

        private int user;//记录第几个用户

        public SemaphoreRunnable(Semaphore semaphore,int user){
            this.semaphore=semaphore;
            this.user=user;
        }

        @Override
        public void run() {
            try {
                // 获取信号量许可
                semaphore.acquire();
                System.out.println("用户"+user+"进入窗口");
                Thread.sleep((long) (Math.random()*1000));
                System.out.println("用户"+user+"买票完成，即将离开--------------");
                Thread.sleep((long) (Math.random()*1000));
                System.out.println("用户"+user+"离开--------------");
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void execute() {
        final Semaphore semaphore=new Semaphore(2);
        //用线程池
        ExecutorService threadPool= Executors.newCachedThreadPool();
        //模拟20个用户
        for (int i = 0; i < 20; i++) {
            //去买票
            threadPool.execute(new SemaphoreRunnable(semaphore,i+1));
        }
        threadPool.shutdown();
    }

    public static void main(String[] args) {
        SemaphoreDemo sd=new SemaphoreDemo();
        sd.execute();
    }
}
