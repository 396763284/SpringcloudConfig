package learn.LeetCode;

import java.util.HashMap;
import java.util.Map;


public class LeetCode {

    public static void main(String[] args) {
//        System.out.println(123/10);
//        System.out.println(isPalindrome(-12121));
//        System.out.println(romanToInt("MCMXCIV"));
//        String[] strs={"flower","flow","flight"};
//        String[] strs={"dog","racecar","car"};
        String[] strs={"aa","a"};
//        String[] strs={"c","acc","ccc"};
//        String[] strs={"",""};
//        System.out.println("c".substring(0,1));
//        System.out.println(longestCommonPrefix(strs));
        String s ="[(({})}]";
        System.out.println(isValid(s));
    }

    /**
     int[] nums={3,3};
     int target = 6;
     twoSum(nums,target).toString();
     */
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> m = new HashMap<Integer, Integer>();
        int[] res = new int[2];
        for(int i=0;i<nums.length;++i){
            if(m.containsKey(target-nums[i])){
                res[0]=i;
                res[1]=m.get(target-nums[i]);
                System.out.println( res[0]+"-"+res[1]);
                break;
            }
            m.put(nums[i],i);
        }
        return res;
    }

    public static int reverse(int x) {
        boolean isNegative =x>0;
        x=Math.abs(x);
        long res=0;
        while(x!=0){
            res=x%10 +res*10 ;
            x/=10;
        }
        if(res>Integer.MAX_VALUE||res<Integer.MIN_VALUE){
            return 0;
        }
        return isNegative?(int)res:-(int)res;
    }

    /*
     * 9. Palindrome Number
     */
    public static boolean isPalindrome_wxp(int x) {
        String str= String.valueOf(x);
        char[] arr= str.toCharArray();
        for (int i = 0; i < arr.length/2; i++) {
            System.out.println(arr[i]+"-"+arr[arr.length-1-i]);
            if(arr[i]!=arr[arr.length-1-i]){
                return false;
            }
        }
        return true;
    }

    /**
     * 9. Palindrome Number
     * Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.
     * @param x
     * @return
     */
    public static boolean isPalindrome(int x) {
        int v=0;
        boolean res=false;
        while(x>v){
            v=v*10+x%10;
            x/=10;
        }
        if(v>x)v/=10;
        System.out.println("x="+x+"--v"+v);
        return v==x;
    }

    /**
     13. Roman to Integer
     */
    public static int romanToInt(String s) {
        char[] arr= s.toCharArray();
        //组装数据
        int[] num={1,5,10,50,100,500,1000};
        char[] roms={'I','V','X','L','C','D','M'};
        Map<String,Integer> map= new HashMap<String,Integer>();
        for (int i = 0; i < roms.length; i++) {
            map.put(String.valueOf(roms[i]),num[i]);
        }
        int count=map.get(String.valueOf(arr[arr.length-1]));
        // 分词
        for (int i = arr.length-1; i>0 ; i--) {
            if(map.get(String.valueOf(arr[i-1]))>=map.get(String.valueOf(arr[i]))){
                count+=map.get(String.valueOf(arr[i-1]));
            }else{
                count-=map.get(String.valueOf(arr[i-1]));
            }
        }
        return count;
    }

    /**
     * 14. Longest Common Prefix
     * @param strs
     * @return
     */
    public static String longestCommonPrefix(String[] strs) {
        if(strs.length == 0)  return "";
        if(strs.length == 1)  return strs[0];
        if(strs[0].equals("")) return strs[0];
        String res="";
        for (int i = 1; i <= strs[0].length(); i++) {
            for (int j = 1; j < strs.length; j++) {
                if(strs[j].length()<i) return res;
                if(!strs[j].substring(0,i).equals(strs[0].substring(0,i))) return res;
            }
            res=strs[0].substring(0,i);
        }
        return res;
    }

    /**
     * 20. Valid Parentheses
     * @param s
     * @return
     */
    public static boolean isValid(String s) {
        // 判断是否同时存在
        if(s.equals("")) return true;
        if((s.contains("(")||s.contains(")")) &&!(s.contains("(")&&s.contains(")"))) return false;
        if((s.contains("[")||s.contains("]"))&& !(s.contains("[")&&s.contains("]"))) return false;
        if((s.contains("{")||s.contains("}"))&& !(s.contains("{")&&s.contains("}"))) return false;


        boolean res= true;
        Map<String,Integer> map= new HashMap<String,Integer>();
        // 建立 括号
        // 判断是否按照顺序排列, 可以根据 正负号来判断是左右括号
        // 这样判断条件就成， 先判断左边括号的值。{[ 应该是-3 + -2 ,若正负号变化，则计算后面的，
        // 如果是 顺序排列，例如 {[]} 肯定是 后一位大于前一位 ，
        // 如果是单个 ()[]{} ,若前一位和后一位的正负不同，绝对值肯定一样，
        map.put("{", -3);
        map.put("[", -2);
        map.put("(", -1);
        map.put(")", 1);
        map.put("]", 2);
        map.put("}", 3);
        char[] ch= s.toCharArray();
        int total=0;
        int count=0;
        for(int i=0 ;i<ch.length-1;i++){
            System.out.println(map.get(String.valueOf(ch[i]))+"--" + map.get(String.valueOf(ch[i+1])));
            if(((map.get(String.valueOf(ch[i+1]))>0 && map.get(String.valueOf(ch[i]))<0) ) && (map.get(String.valueOf(ch[i]))+map.get(String.valueOf(ch[i+1]))!=0) ) return false;
            if(((map.get(String.valueOf(ch[i+1]))>0 && map.get(String.valueOf(ch[i]))>0)||(map.get(String.valueOf(ch[i+1]))<0 && map.get(String.valueOf(ch[i]))<0) ) && map.get(String.valueOf(ch[i+1]))<map.get(String.valueOf(ch[i+1]))) return false;
            if (map.get(String.valueOf(ch[i])) > 0) {
                total += map.get(String.valueOf(ch[i]));
                count++;
            } else if (map.get(String.valueOf(ch[i])) < 0) {
                total += map.get(String.valueOf(ch[i]));
                count--;
            }
             // 若为同一侧的括号，则应该按顺序来排列
            if(map.get(String.valueOf(ch[i+1]))<0 && map.get(String.valueOf(ch[i]))>0 ) {
                //若左边括号，则相加， 右边括号则相减
                if(total!=0 || count!=0) return false;
            }
        }
        return res;
    }
}
