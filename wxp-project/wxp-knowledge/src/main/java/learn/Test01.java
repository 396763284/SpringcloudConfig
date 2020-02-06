package learn;


/**
 *
 * 二维数组中的查找
 *
 在一个二维数组中，每一行都按照从左到右递增的顺序排序，
 每一列都按照从上到下递增的顺序排序。请完成一个函数，
 输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class Test01 {

    public static void main(String[] args) {
        int target=9;
        int [][] array={{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        System.out.println(BestFind(target,array));
    }

    public static boolean MyFind(int target, int [][] array) {
        for(int i=0;i<array.length;i++){
           for(int j=0;j<array[i].length;j++ ){
               if(array[i][j]==target){
                   return true;
               }
            }
        }
        return false;
    }

    /**
     * 首先我们选择从左下角开始搜寻，(为什么不从左上角开始搜寻，左上角向右和向下都是递增，
     * 那么对于一个点，对于向右和向下会产生一个岔路；如果我们选择从左下脚开始搜寻的话，如果大于就向右，如果小于就向下)。
     * @param target
     * @param array
     * @return
     */
    public static boolean BestFind(int target, int [][] array) {
        int len=array.length-1;
        int i=0;
        while ((len>=0)&&(i<array[0].length)){
            System.out.println(array[len][i]);
            if(array[len][i]>target){
                len--;
            }else if(array[len][i]<target){
                i++;
            }else{
                return  true;
            }
        }
        return  false;
    }


}
