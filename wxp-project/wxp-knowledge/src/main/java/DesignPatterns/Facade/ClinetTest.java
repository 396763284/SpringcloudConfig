package DesignPatterns.Facade;

/**
 * @description:
 * @author: 点岩喵
 * @date: 2019-04-25 15:54
 */
public class ClinetTest {
    public static void main(String[] args) {
        EncryptFacade facade=new EncryptFacade();
        facade.FileEncrypt("ttt.txt");
    }
}
