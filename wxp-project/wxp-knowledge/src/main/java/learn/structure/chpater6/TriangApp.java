package learn.structure.chpater6;

/**
 * 三角函数
 */
public class TriangApp {
    static int theNumber;

    public static void main(String[] args) {

    }

    public int triang(int n){
        if(n==1){
            return 1;
        }else{
            return n+triang(n-1);
        }
    }

}
