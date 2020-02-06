package DesignPatterns.Proxy;

/**
 * @description:
 * @author: 点岩喵
 * @date: 2019-04-25 16:32
 */
public class ProxySearcher implements  Searcher{
    private RealSearcher realSearcher=new RealSearcher();

    private Logger logger;
    private AccessValidator validator;


    @Override
    public String DoSearch(String userId, String keyword) {

        if(this.validator(userId)){
            String result =  realSearcher.DoSearch(userId,keyword);
            this.log(userId);
            return result;
        }else{
            return  userId+"登录失败";
        }

    }

    private boolean validator(String userId){
        validator= new AccessValidator();
        return validator.validator(userId);
    }

    private void log(String userId){
        logger= new Logger();
        logger.Log(userId);
    }

}
