package DesignPatterns.State;

/**
 * @description: 环境类
 * @author: 点岩喵
 * @date: 2019-04-27 14:20
 */
public class Account {
   private AccountState state;
   private String owner;
   private double count=0; //默认值
   public Account(String owner,Double count){
      this.count=count;
      this.owner=owner;
      this.state= new NormalState(this);
   }

   public AccountState getState() {
      return state;
   }

   public void setState(AccountState state) {
      this.state = state;
   }

   public String getOwner() {
      return owner;
   }

   public void setOwner(String owner) {
      this.owner = owner;
   }

   public Double getCount() {
      return count;
   }

   public void setCount(Double count) {
      this.count = count;
   }

   /**
    * 存款
    * @param count
    */
   public void deposit(double count){
      System.out.println(this.owner+"存款了"+count);
      state.deposit(count);
      System.out.println(this.owner+"余额为："+this.count);
      System.out.println("现在状态为"+this.state.getClass().getName());
   }

   /**
    * 取款
    * @param count
    */
   public void withdraw(double count){
      System.out.println(this.owner+"取款了"+count);
      state.withdraw(count);
      System.out.println(this.owner+"余额为："+this.count);
      System.out.println("现在状态为"+this.state.getClass().getName());
   }



}
