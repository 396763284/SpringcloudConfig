/**
 * @description:
 * @author: 点岩喵
 * @date: 2019-08-15 9:33
 */
public class Test {

    public static void main(String[] args) {
        String s="duck";
        StringBuffer sb=new StringBuffer("duck");
        String e=new String("duck");
        String t=e;

        System.out.println(s.equals(sb));
        System.out.println(s.equals(e));
        System.out.println(t.equals(sb));
        System.out.println(s==t);


        int i=1,j=10;
        do{
            if(i++>--j){
                continue;
            }
        }while(i<5);
        System.out.println("i="+i+"j+"+j);

        int x=5;
        Test test=new Test();
        test.doStuff(x);
        System.out.print("main x = "+ x);

    }

    void doStuff(int x){
        System.out.println(" doStuffx ="+ x++);
    }

}
