package per.wxp.redis.service;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import per.wxp.redis.entity.User;
import per.wxp.redis.mapper.UserMapper;

import javax.annotation.Resource;


@Service
@CacheConfig(cacheNames = "users")
public class UserService {


    @Resource
    private UserMapper mapper;


    @Cacheable(key ="T(String).valueOf(#userId)")
    public User selectByPrimaryKey(Integer userId){
        return mapper.selectByPrimaryKey( userId);
    }

    public int insert(User record){

        return mapper.insert(record);
    }



    @CachePut(key ="T(String).valueOf(#record.userId)")
    public User updateByPrimaryKey(User record){

        mapper.updateByPrimaryKey(record);

        System.out.println(record.toString());
        return record;
    }

    @CacheEvict(key ="T(String).valueOf(#userId)")
    public  int deleteByPrimaryKey(Integer userId){
        return mapper.deleteByPrimaryKey(userId);
    }



}
