package learn.structure.chapter3;

/**
 * 有序数组
 */
public class OrderArray {
    private long[] a;
    private int nElems;

    public OrderArray(int max){
      a = new  long[max];
      nElems=0;
    }

    public int Size(){
        return nElems;
    }

    public void insert(long value){
        int  j;
        for ( j = 0; j < nElems ; j++) {
            if(a[j]>value){
                break;
            }
        }
        for (int i = nElems; i > j ; i--) {
            a[i]=a[i-1];
        }
        a[j]=value;
        nElems++;
    }

    public int find(long searchKey){
        int cur;
        int lowerBound=0;
        int upperBound=nElems-1;
        while(true){
            cur= (lowerBound+upperBound)/2;
            if(a[cur] ==searchKey){
                return cur;
            }else if (lowerBound > upperBound){
                return nElems;
            } else {
                if (a[cur] < searchKey) {
                    lowerBound=cur+1;
                }else{
                    upperBound=cur-1;
                }
            }
        }
    }

    public boolean delete(long value){
        int i= find(value);
        System.out.println(i);
        if (i==nElems){
            return  false;
        }else{
            for (int k = i; k <nElems ; k++) {
                a[k]=a[k+1];
            }
            nElems--;
            return true;
        }

    }

    public void display(){
        for (int i = 0; i < nElems; i++) {
            System.out.println(a[i]+"");
        }
    }
}
