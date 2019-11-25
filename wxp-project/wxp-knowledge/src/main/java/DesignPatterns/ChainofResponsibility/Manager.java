package DesignPatterns.ChainofResponsibility;

/**
 * @description:
 * @author: 点岩喵
 * @date: 2019-04-25 17:30
 */
public class Manager extends Approver {

    public Manager(String name) {
        super(name);
    }

    @Override
    public void processRequest(PurchaseRequest request) {
        if(request.getDays()>=3 && request.getDays()<10){
            System.out.println(this.name+"审批");
        }else {
            this.successor.processRequest(request);
        }
    }
}
