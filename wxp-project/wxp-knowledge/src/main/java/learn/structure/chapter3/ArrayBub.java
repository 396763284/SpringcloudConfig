package learn.structure.chapter3;

public class ArrayBub {

    public static void main(String[] args) {

//        testOrderArray();
        testHighArray();

    }


    public static void testHighArray(){
        int maxSize=100;
        HighArray arr= new HighArray(maxSize);
        arr.insert(3);
        arr.insert(2);
        arr.insert(1);
//        arr.insert(8);
//        arr.insert(7);
//        arr.insert(6);
//        arr.insert(3);
//        arr.insert(1);
        arr.display();
        System.out.println("bubbleSort");
        arr.bubbleSort();
        arr.display();

        boolean existsed= arr.find(34);
        System.out.println("exists="+existsed);

        boolean deleted = arr.delete(22);
        System.out.println("deleted="+deleted);
        arr.display();

    }

    public static void testOrderArray(){
        int maxSize=100;
        OrderArray arr= new OrderArray(maxSize);
        arr.insert(33);
        arr.insert(12);
        arr.insert(22);
        arr.insert(66);
        arr.insert(44);
        arr.insert(88);
        arr.insert(55);
        arr.insert(56);
        arr.insert(77);
        arr.display();

        int  existsed= arr.find(56);
        System.out.println("exists="+existsed);

        boolean deleted = arr.delete(55);
        System.out.println("deleted="+deleted);
        arr.display();
    }
}
