package DesignPatterns.Proxy;

/**
 * @description:
 * @author: 点岩喵
 * @date: 2019-04-25 16:29
 */
public class AccessValidator {

    public boolean validator(String name){

        return name.equals("wxp")?true:false;
    }

}
