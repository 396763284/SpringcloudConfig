package DesignPatterns.State;

/**
 * @description: 状态类
 * @author: 点岩喵
 * @date: 2019-04-27 14:20
 */
abstract class AccountState {
    protected Account acc;
    public abstract void deposit(double count);
    public abstract void withdraw(double count);
    public abstract void computeInterest();
    public abstract void stateCheck();
}
