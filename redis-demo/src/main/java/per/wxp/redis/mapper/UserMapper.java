package per.wxp.redis.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import per.wxp.redis.entity.User;


@Mapper
public interface UserMapper {

    int deleteByPrimaryKey(Integer userId);


    int insert(User record);

    int insertSelective(User record);


    User selectByPrimaryKey(Integer userId);


    int updateByPrimaryKeySelective(User record);


    int updateByPrimaryKey(User record);
}