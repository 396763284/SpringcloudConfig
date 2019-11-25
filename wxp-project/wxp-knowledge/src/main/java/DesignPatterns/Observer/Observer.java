package DesignPatterns.Observer;

/**
 * @description:
 * @author: 点岩喵
 * @date: 2019-04-26 15:34
 */
public interface Observer {
    public String getName();
    public void setName(String name);
    public int getCount();
    public void setCount();
    public void help();
    public void receive(int count);
    public void beChanged(Subject subject);
    public void beAttcked(Subject subject);
}
