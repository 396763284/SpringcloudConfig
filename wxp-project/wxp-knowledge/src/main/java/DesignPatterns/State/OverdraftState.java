package DesignPatterns.State;

/**
 * @description:
 * @author: 点岩喵
 * @date: 2019-04-27 15:04
 */
public class OverdraftState extends AccountState{

    public OverdraftState(AccountState state){
        this.acc=state.acc;
    }

    @Override
    public void deposit(double count) {
        acc.setCount(this.acc.getCount()+count);
        stateCheck();
    }

    @Override
    public void withdraw(double count) {
        acc.setCount(this.acc.getCount()-count);
        stateCheck();
    }

    @Override
    public void computeInterest() {

    }

    @Override
    public void stateCheck() {
        if(acc.getCount()>=0){
            acc.setState(new NormalState(this));
        }else if(acc.getCount()==-2000){
            acc.setState(new RestrictedState(this));
        }else {
            System.out.println("受限制");
        }
    }
}
