package per.wxp.rabbitmq;

import per.wxp.rabbitmq.Consumer.ExchangeConsumer;

/**
 * @description:
 * @author: 点岩喵
 * @date: 2019-08-19 10:54
 */
public class TestConsumer1 {

    public static void main(String[] args) {
        try {

//            SimpleConsumer.receive();


            //  work
            // 轮询
            // RoundRobinConsumer.receiveWork1();

            // 公平分发
            // FairDispatchConsumer.receiveWork1();

            //  subscribe
//            ExchangeConsumer.consumer1();
//            ExchangeConsumer.consumer3();

            ExchangeConsumer.consumer5();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
