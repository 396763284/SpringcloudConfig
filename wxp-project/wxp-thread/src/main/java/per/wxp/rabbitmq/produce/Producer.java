package per.wxp.rabbitmq.produce;


import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import per.wxp.rabbitmq.util.ConnectionUtil;

/**
 * @description:  简单队列
 * @author: 点岩喵
 * @date: 2019-08-19 10:06
 */
public class Producer {

    private final static String QUEUE_NAME = "q_test_01";

    private final static String EXCHANGE_NAME = "exchange_test";


    private final static String EXCHANGE_DIRECT_NAME="test_exchange_direct";

    private final static String EXCHANGE_TOPIC_NAME="test_exchange_topic";





    public static void send(String message) throws Exception {
        // 获取到连接以及mq通道
        Connection connection = ConnectionUtil.getConnection();
        // 从连接中创建通道
        Channel channel = connection.createChannel();

        // 声明（创建）队列
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);

        // 消息内容
        for (int i = 0; i < 100; i++) {
            // 消息内容
            message = "" + i;
            channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
            System.out.println(" [x] Sent '" + message + "'");

            Thread.sleep(i * 10);
        }


        //关闭通道和连接
        channel.close();
        connection.close();
    }

    /**
     *  exchange 发送到交换机
     *  fanout
     *  subscribe 模式
     * @param message
     * @throws Exception
     */
    public static void FanoutSend(String message) throws Exception {
        // 获取到连接以及mq通道
        Connection connection = ConnectionUtil.getConnection();
        // 从连接中创建通道
        Channel channel = connection.createChannel();

        // 声明exchange
        channel.exchangeDeclare(EXCHANGE_NAME, "fanout");
        // 消息内容
        for (int i = 0; i < 100; i++) {
            // 消息内容
            message = "" + i;
            channel.basicPublish(EXCHANGE_NAME, QUEUE_NAME, null, message.getBytes());
            System.out.println(" [x] Sent '" + message + "'");

            Thread.sleep(i * 10);
        }
        //关闭通道和连接
        channel.close();
        connection.close();
    }


    /**
     *  exchange 发送到交换机
     *  subscribe 模式
     * @param message
     * @throws Exception
     */
    public static void directSend(String message) throws Exception {
        // 获取到连接以及mq通道
        Connection connection = ConnectionUtil.getConnection();
        // 从连接中创建通道
        Channel channel = connection.createChannel();

        // 声明exchange  direct 交换机类型
        channel.exchangeDeclare(EXCHANGE_DIRECT_NAME, "direct");
        // 消息内容
        for (int i = 0; i < 30; i++) {
            // 消息内容
            message = "" + i;
            channel.basicPublish(EXCHANGE_DIRECT_NAME, "update", null, message.getBytes());
            System.out.println(" [x] Sent '" + message + "'");

            Thread.sleep(i * 10);
        }
        //关闭通道和连接
        channel.close();
        connection.close();
    }


    public static void topSend(String message) throws Exception {
        // 获取到连接以及mq通道
        Connection connection = ConnectionUtil.getConnection();
        // 从连接中创建通道
        Channel channel = connection.createChannel();
        // 声明exchange  direct 交换机类型
        channel.exchangeDeclare(EXCHANGE_TOPIC_NAME, "topic");
        for (int i = 0; i < 30; i++) {
            // 消息内容
            message = "" + i;
            channel.basicPublish(EXCHANGE_TOPIC_NAME, "item.1", null, message.getBytes());
            System.out.println(" [x] Sent '" + message + "'");

            Thread.sleep(i * 10);
        }
        //关闭通道和连接
        channel.close();
        connection.close();

    }

}
