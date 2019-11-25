package DesignPatterns.ChainofResponsibility;

/**
 * @description:
 * @author: 点岩喵
 * @date: 2019-04-25 17:22
 */
abstract class Approver {
    protected Approver successor;
    protected String name;

    public Approver(String name){
        this.name=name;
    }

    public void setApprover(Approver approver) {
        this.successor = approver;
    }

    public abstract void processRequest(PurchaseRequest request);
}
