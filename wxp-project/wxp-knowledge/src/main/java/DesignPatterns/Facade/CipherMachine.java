package DesignPatterns.Facade;

/**
 * @description:数据加密类，充当子系统类
 * @author: 点岩喵
 * @date: 2019-04-25 15:49
 */
public class CipherMachine {

    public void cipher(String fileName){
        System.out.println("CipherMachine file "+fileName);
    }

}
