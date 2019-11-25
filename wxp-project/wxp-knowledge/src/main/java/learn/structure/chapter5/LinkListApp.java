package learn.structure.chapter5;

public class LinkListApp {
    public static void main(String[] args) {
        LinkList theList= new LinkList();
        theList.insertFirst(2,1231.2);
        theList.insertFirst(4,1231.22);
        theList.insertFirst(1,32.2);
        theList.displayList();
//        theList.deleteFirst();

        theList.delete(1);
        theList.displayList();

    }
}
