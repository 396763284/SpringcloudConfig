package DesignPatterns.ChainofResponsibility;

/**
 * @description:
 * @author: 点岩喵
 * @date: 2019-04-25 17:32
 */
public class GeneralManager extends Approver {
    public GeneralManager(String name) {
        super(name);
    }

    @Override
    public void processRequest(PurchaseRequest request) {
        if(request.getDays()>=10&&request.getDays()<30){
            System.out.println(this.name+"审批");
        }else {
            this.successor.processRequest(request);
        }
    }
}
