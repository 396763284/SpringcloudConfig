package DesignPatterns.Strategy;

/**
 * @description:
 * @author: 点岩喵
 * @date: 2019-04-27 15:51
 */
public class ChildrenDiscount implements Discount {
    @Override
    public double calculate(Double price) {
        System.out.println("儿童票：");
        return price-10;
    }
}
