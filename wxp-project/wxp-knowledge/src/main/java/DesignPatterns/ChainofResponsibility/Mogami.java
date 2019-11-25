package DesignPatterns.ChainofResponsibility;

/**
 * @description:
 * @author: 点岩喵
 * @date: 2019-04-25 17:34
 */
public class Mogami extends Approver {
    public Mogami(String name) {
        super(name);
    }

    @Override
    public void processRequest(PurchaseRequest request) {
        if(request.getDays()>30){
            System.out.println("无法审批"+this.name);
        }
    }
}
