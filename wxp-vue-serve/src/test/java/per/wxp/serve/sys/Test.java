package per.wxp.serve.sys;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @description:
 * @author: 点岩喵
 * @date: 2019-06-04 16:12
 */
public class Test {

    public static void main(String[] args) throws Exception {
        List<Map<String, Object>> menus= new ArrayList<Map<String, Object>>();
        Map<String, Object> root1 = new HashMap<>();
        root1.put("PERMISSION_ID",78);
        root1.put("PID",null);
        root1.put("TITLE","数据同步");
        Map<String, Object> level1 = new HashMap<>();
        level1.put("PERMISSION_ID",79);
        level1.put("PID",78);
        level1.put("TITLE","同步任务");

        Map<String, Object> root2 = new HashMap<>();
        root2.put("PERMISSION_ID",83);
        root2.put("PID",null);
        root2.put("TITLE","系统管理");
        Map<String, Object> level2 = new HashMap<>();
        level2.put("PERMISSION_ID",84);
        level2.put("PID",83);
        level2.put("TITLE","用户管理");
        menus.add(root1);
        menus.add(level1);
        menus.add(root2);
        menus.add(level2);

        build(menus);
    }

    private static void build(List<Map<String, Object>> list) throws  Exception{
        List<Map<String, Object>> tree= new ArrayList<Map<String, Object>>();
        for (Map<String, Object> map : list) {
            if(null==map.get("PID")){
                tree.add(map);
            }
        }
        System.out.println(tree.size());
        for (Map<String, Object> treeMap : tree) {
            for (Map<String, Object> childmap : list) {
                if(null!=childmap.get("PID")){
                    if(childmap.get("PID").equals(treeMap.get("PERMISSION_ID"))){
                        treeMap.put("child",childmap);
                    }
                }
            }
        }
        System.out.println(tree.toString());

    }



}
