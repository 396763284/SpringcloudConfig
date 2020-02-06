package DesignPatterns.Strategy;

/**
 * @description:
 * @author: 点岩喵
 * @date: 2019-04-27 15:52
 */
public class VIPDiscount implements Discount {
    @Override
    public double calculate(Double price) {
        System.out.println("VIP票：");
        System.out.println("增加积分！");
        return price * 0.5;
    }
}
