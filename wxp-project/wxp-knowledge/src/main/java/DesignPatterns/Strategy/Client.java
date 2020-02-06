package DesignPatterns.Strategy;

/**
 * @description:
 * @author: 点岩喵
 * @date: 2019-04-27 15:52
 */
public class Client {
    public static void main(String[] args) {
        MovieTicket mt=new MovieTicket();
        double originalPrice = 60.0;
        double currentPrice;

        mt.setPrice(originalPrice);
        System.out.println("原始价为：" + originalPrice);
        mt.setDiscount(new ChildrenDiscount());
        System.out.println("现在价钱："+mt.getPrice());


    }
}
