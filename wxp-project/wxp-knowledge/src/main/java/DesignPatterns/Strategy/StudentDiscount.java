package DesignPatterns.Strategy;

/**
 * @description:
 * @author: 点岩喵
 * @date: 2019-04-27 15:50
 */
public class StudentDiscount implements Discount {
    @Override
    public double calculate(Double price) {
        System.out.println("学生票：");
        return 0.8*price;
    }
}
