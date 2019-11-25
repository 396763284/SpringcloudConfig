package learn.structure.imitate.lineTable;

public class MyArrayList implements MyList {

    Object[] elementData = new Object[4];
    int size;

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(int index, Object e) {
        if(index>size-1){
            Object[] newArray= new Object[elementData.length*2];
            for (int i = 0; i <elementData.length ; i++) {
                newArray[i]=elementData[i];
            }
            elementData=newArray;
        }
        for (int i = size; i >= index; i--) {
            elementData[i+1]=elementData[i];
        }
        elementData[index]=e;
        size++;
    }

    @Override
    public void add(Object e) {
        this.add(size,e);
    }

    @Override
    public Object get(int index) {
        return elementData[index];
    }

    @Override
    public boolean isEmpty() {
        return  size==0;
    }

    @Override
    public void remove(int index) {
        for (int i = index; i <size-1; i++) {
            elementData[i]=elementData[i+1];
        }
        size--;
    }

    @Override
    public void remove(Object e) {
        for (int i = 0; i <size ; i++) {
            if(elementData[i].equals(e)){
                remove(i);
            }
        }
    }

    @Override
    public void replice(int index, Object e) {
        elementData[index]=e;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
       if(size==0){
           return "[]";
       }else{
           for (int i = 0; i <size ; i++) {
               if(i==size-1){
                   sb.append(elementData[i].toString());
               }else{
                   sb.append(elementData[i].toString()+",");
               }
           }
       }
       return  sb.toString();
    }



    public static void main(String[] args) {
        MyList list= new MyArrayList();
        list.add(111);
        list.add(222);
        list.add(333);
        list.add(444);
        list.add(555);
        list.add(5,666);

        System.out.println(list.size());
        System.out.println(list.toString());
    }
}
