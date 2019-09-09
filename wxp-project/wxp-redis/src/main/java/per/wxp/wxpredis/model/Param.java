package per.wxp.wxpredis.model;

import java.io.Serializable;

/**
 * @description:
 * @author: 点岩喵
 * @date: 2019-08-14 9:39
 */
public class Param implements Serializable {

    private long id;
    private String name;
    private String desc;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
