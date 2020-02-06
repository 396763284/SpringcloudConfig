package learn.structure.chapter3;

/**
 * 无序数组
 */
public class HighArray {
    private long[] a;
    private int nElems;

    public HighArray(int max) {
        a=new long[max];
        nElems=0;
    }

    public boolean find(long searchKey){
        int i;
        for (i = 0; i < nElems ; i++) {
            if(a[i]==searchKey){
                break;
            }
        }
        if (i==nElems){
            return false;
        }else{
            return  true;
        }
    }

    public void insert(long value){
        a[nElems]= value;
        nElems++;
    }
    public boolean delete(long value){
        int i ;
        for ( i = 0; i < nElems ; i++) {
            if(a[i]==value){
            break;
            }
        }
        if (i==nElems){
            return false;
        }
        else{
            for (int k= i ;k<nElems;k++){
                a[k]=a[k+1];
            }
            nElems--;
            return  true;
        }
    }

    // 冒泡排序
    public void bubbleSort(){
        System.out.println("nElems="+nElems);
        for (int i = nElems-1; i > 0; i--) {
            for (int j = 0; j < nElems-1 ; j++) {
                System.out.println("a[i]="+a[i]+"--a[j]="+a[j]);
                if(a[i] < a[j]){
                    long tmp= a[i];
                    a[j]=tmp;
                    a[i]=a[j];
                }
                System.out.println("end---a[i]="+a[i]+"--a[j]="+a[j]);
            }
        }
    }

    public void display(){
        for (int i = 0; i < nElems; i++) {
            System.out.println(a[i]+"");
        }
    }
}
