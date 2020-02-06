package learn.structure.chapter5;

public class LinkList {

    private Link first;

    public LinkList() {
        this.first = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void insertFirst(int id, double dData) {
        Link newLink = new Link(id, dData);
        newLink.next = this.first;
        this.first = newLink;
    }

    public Link deleteFirst() {
        Link temp = first;
        this.first = this.first.next;
        return temp;
    }

    public void displayList() {
        System.out.println("show linkList");
        Link current = first;
        while (current != null) {
            current.display();
            ;
            current = current.next;
        }

    }

    public Link find(int key) {
        Link current = first;
        while (current.iData != key) {
            if (current.next == null) {
                return null;
            } else {
                current = current.next;
            }
        }
        return current;
    }

    public Link delete(int key){
        Link current= first;
        Link previous=first;
        while (current.iData != key){
            if(current.next==null){
                return null;
            }else{
                previous=current;
                current=current.next;
            }
        }
        // 删除 第一个节点 first
        if(current==first){
            first=first.next;
        }else{
            previous.next=current.next;
        }
        return current;
    }


     class Link {

        public int iData;
        public double dData;
        public Link next;

        public Link(int iData, double dData) {
            this.iData = iData;
            this.dData = dData;
        }

        public  void display(){
            System.out.println("{iData="+iData+",dData="+dData+"}");
        }
    }
}
