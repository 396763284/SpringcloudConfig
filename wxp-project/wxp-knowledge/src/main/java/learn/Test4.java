package learn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test4 {
    public static void main(String[] args) {

//        System.out.println(getMap().get("key").toString());
//        System.out.println(getString());
//        System.out.println(getInt());

        System.out.println(getList().toString());
    }

    private static Map<String,String> getMap(){
        Map<String,String> map= new HashMap<String,String>();
        map.put("key","init");
        try {
            map.put("key","try");
            return  map;
        } catch (Exception e) {
            map.put("key","catch");
            e.printStackTrace();
        } finally {
            map.put("key","finally");
            map= null;
            System.out.println(111);
            return  map;
        }
//        return  map;
    }

    private static String getString(){
        String param="";
        param="init";
        try {
            param="try";
            return  param;
        } catch (Exception e) {
            param="catch";
            e.printStackTrace();
        } finally {
            param="finally";
            param= null;
            System.out.println(111);
            return  param;
        }
//        return  param;
    }

    private static int getInt(){
        int param=0;
        try {
            param=2;
            return  param;
        } catch (Exception e) {
            param=3;
            e.printStackTrace();
        } finally {
            ++param;
//            param=3;
//            param= 0;
//            System.out.println(111);
//            return  param;
        }
        return  param;
    }

    private static List<String> getList(){
        List<String> list=new ArrayList<String>();
        try {
            list.add("init");
            return  list;
        } catch (Exception e) {
            list.add("catch");
            e.printStackTrace();
        } finally {
            list.add("finally");
            list=null;
//            System.out.println(111);
//            return  list;
        }
        return  list;
    }
}
