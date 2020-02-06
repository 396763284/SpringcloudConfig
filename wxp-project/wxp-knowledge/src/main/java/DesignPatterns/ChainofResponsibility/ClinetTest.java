package DesignPatterns.ChainofResponsibility;

/**
 * @description:
 * @author: 点岩喵
 * @date: 2019-04-25 17:35
 */
public class ClinetTest {

    public static void main(String[] args) {
        Approver manager,director,generalManager,mogami;
        manager=new Manager("经理");
        director=new Director("主任");
        generalManager=new GeneralManager("总经理");
        mogami=new Mogami(" ");

        director.setApprover(manager);
        manager.setApprover(generalManager);
        generalManager.setApprover(mogami);


        PurchaseRequest request1=new PurchaseRequest();
        request1.setDays(4);
        director.processRequest(request1);

        PurchaseRequest request2=new PurchaseRequest();
        request2.setDays(35);
        director.processRequest(request2);

        PurchaseRequest request3=new PurchaseRequest();
        request3.setDays(14);
        director.processRequest(request3);

    }

}
