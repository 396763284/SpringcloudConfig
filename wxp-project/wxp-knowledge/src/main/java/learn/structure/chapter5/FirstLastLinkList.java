package learn.structure.chapter5;

/**
 * 双端链表
 */
public class FirstLastLinkList {

    private Link first;

    public FirstLastLinkList(Link first) {
        this.first = null;
    }

    public boolean isEmpty(){
        return first==null;
    }
    public void displayList(){
        Link current= first;
        while(current.next!=null){
            current.display();
            current=current.next;
        }
    }

    public void insertLink(int iData,double dDate){
        Link newLink= new Link(iData,dDate);
        newLink.next=this.first;
        this.first=newLink;
    }

    public Link delete(int key){
        Link current= first;
        Link previous= first;
        while(current.iData!=key){
            if(current.next==null){
                return null;
            }else{
                previous=current;
                current=current.next;
            }
        }
        if(current==first){
            first=current.next;
        }else{
            previous.next =first.next;
        }
        return  current;
    }



    class Link{
        public int iData;
        public double dData;
        public Link next;

        public Link(int iData, double dData) {
            this.iData = iData;
            this.dData = dData;
        }
        public void display(){
            System.out.println("{idata="+iData+" dData="+dData+"}");
        }
    }

}
