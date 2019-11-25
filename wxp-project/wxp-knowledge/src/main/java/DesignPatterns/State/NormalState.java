package DesignPatterns.State;

/**
 * @description:
 * @author: 点岩喵
 * @date: 2019-04-27 14:51
 */
public class NormalState extends AccountState {

    public NormalState(Account account){
        this.acc=account;
    }

    public NormalState(AccountState state) {
        this.acc = state.acc;
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
        if(acc.getCount()>-2000&& acc.getCount()<=0){
            acc.setState(new OverdraftState(this));
        }else if(acc.getCount()==-2000){
            acc.setState(new RestrictedState(this));
        }else {
            System.out.println("受限制");
        }
    }
}
