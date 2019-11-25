package DesignPatterns.Proxy;

/**
 * @description:
 * @author: 点岩喵
 * @date: 2019-04-25 16:32
 */
public class RealSearcher implements Searcher {
    @Override
    public String DoSearch(String userId, String keyword) {
        System.out.println();
        String result="用户："+userId+"访问了【"+keyword+"】";
        return result;
    }
}
