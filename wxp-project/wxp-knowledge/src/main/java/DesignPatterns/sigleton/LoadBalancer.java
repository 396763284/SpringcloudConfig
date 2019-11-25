package DesignPatterns.sigleton;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LoadBalancer {

    private static LoadBalancer loadBalancer=null;

    private List serverList = null;

    private LoadBalancer(){
        serverList=new ArrayList();
    }

    public static LoadBalancer getLoadBalancer(){
        if(loadBalancer==null){
            loadBalancer=new LoadBalancer();
        }
        return  loadBalancer;
    }

    public void addServer(String s){
        serverList.add(s);
    }

    public void removeServer(String s){
        serverList.remove(s);
    }

    public String getServer(){
        Random random = new Random();
        String s= String.valueOf(random.nextInt(serverList.size()));
        return s;
    }

}
