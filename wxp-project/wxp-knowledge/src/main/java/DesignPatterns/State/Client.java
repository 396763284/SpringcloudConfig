package DesignPatterns.State;

/**
 * @description:
 * @author: 点岩喵
 * @date: 2019-04-27 15:29
 */
public class Client {
    public static void main(String[] args) {
        Account account=new Account("WXP",100.0);
        account.deposit(100);
        account.withdraw(300);
        account.withdraw(3000);
    }
}
