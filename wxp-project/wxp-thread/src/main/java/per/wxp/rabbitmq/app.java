package per.wxp.rabbitmq;



import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import per.wxp.rabbitmq.Consumer.SimpleConsumer;
import per.wxp.rabbitmq.produce.Producer;
import per.wxp.rabbitmq.util.ConnectionUtil;

/**
 * @description:
 * @author: 点岩喵
 * @date: 2019-08-19 10:05
 */
public class app {

    public static void main(String[] args) {
        String message = "Hello! ";
        try {

            // Producer.send(message);


//            Producer.FanoutSend(message);

//            Producer.directSend(message);

            Producer.topSend(message);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
