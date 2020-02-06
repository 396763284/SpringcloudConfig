package DesignPatterns.Strategy;

/**
 * @description:
 * @author: 点岩喵
 * @date: 2019-04-27 15:48
 */
public class MovieTicket {
    private Discount discount;
    private Double price;

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public double getPrice() {
        return discount.calculate(this.price);
    }
}
