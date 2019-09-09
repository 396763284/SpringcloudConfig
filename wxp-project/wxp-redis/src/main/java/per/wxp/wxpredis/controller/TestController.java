package per.wxp.wxpredis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.redis.util.RedisLockRegistry;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

/**
 * @description:
 * @author: 点岩喵
 * @date: 2019-08-14 10:56
 */
@RestController
public class TestController {

    @Autowired
    private RedisLockRegistry redisLockRegistry;


    @GetMapping("test")
    public String test() throws InterruptedException{
        Lock lock = redisLockRegistry.obtain("lock");
        boolean b1 = lock.tryLock(3, TimeUnit.SECONDS);
        System.out.println("b1 is : {}"+b1);
        TimeUnit.SECONDS.sleep(5);
        boolean b2 = lock.tryLock(3, TimeUnit.SECONDS);
        System.out.println("b2 is : {}"+b2);
        lock.unlock();
        lock.unlock();
        return "suc";
    }



}
