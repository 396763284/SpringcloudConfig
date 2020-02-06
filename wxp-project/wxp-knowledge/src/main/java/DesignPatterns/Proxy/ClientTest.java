package DesignPatterns.Proxy;

/**
 * @description:
 * @author: 点岩喵
 * @date: 2019-04-25 16:44
 */
public class ClientTest {
    public static void main(String[] args) {
        Searcher searcher=new ProxySearcher();
        System.out.println(searcher.DoSearch("wxp","wwww"));
        System.out.println(searcher.DoSearch("ww","wwww"));

    }
}
