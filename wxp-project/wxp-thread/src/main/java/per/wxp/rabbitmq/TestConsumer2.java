package per.wxp.rabbitmq;

import per.wxp.rabbitmq.Consumer.ExchangeConsumer;
import per.wxp.rabbitmq.Consumer.FairDispatchConsumer;
import per.wxp.rabbitmq.Consumer.RoundRobinConsumer;

/**
 * @description:
 * @author: 点岩喵
 * @date: 2019-08-19 10:54
 */
public class TestConsumer2 {

    public static void main(String[] args) {
        try {
            //轮询
//            RoundRobinConsumer.receiveWork2();

            // 公平分发
            //FairDispatchConsumer.receiveWork2();

            // subscribe
//            ExchangeConsumer.consumer2();

//            ExchangeConsumer.consumer4();

            ExchangeConsumer.consumer6();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
