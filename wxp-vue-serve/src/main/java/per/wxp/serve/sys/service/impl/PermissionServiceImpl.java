package per.wxp.serve.sys.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import per.wxp.serve.common.model.PageResult;
import per.wxp.serve.sys.mapper.PermissionMapper;
import per.wxp.serve.sys.mapper.RoleMapper;
import per.wxp.serve.sys.service.PermissionService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: 点岩喵
 * @date: 2019-06-10 19:02
 */
@Service
public class PermissionServiceImpl implements PermissionService {
    private Logger logger= LoggerFactory.getLogger(this.getClass());

    @Autowired
    private PermissionMapper permissionMapper;
    @Autowired
    private RoleMapper roleMapper;

    @Override
    public List<Map<String, Object>> qryMenusRolesByUcode(Map<String, Object> params) {
        List<Map<String ,Object>> roles = new ArrayList<Map<String ,Object>>();

        List<Map<String, Object>> permissions= new ArrayList<Map<String, Object>>();

        roles = roleMapper.findRolesByUcode(params);
        permissions = permissionMapper.qryPermissionByUser(params);

        for (Map<String, Object> role : roles) {
            List<Map<String, Object>> roleMenu= new ArrayList<Map<String, Object>>();
            List<String> rolePermission= new ArrayList<String>();
            for (Map<String, Object> perm : permissions) {
                if(perm.get("type").equals("O")){
                    if(perm.get("role_code").equals(role.get("role_code"))){
                        roleMenu.add(perm);
                    }
                }else if (perm.get("type").equals("F")){
                    if(perm.get("role_code").equals(role.get("role_code"))){
                        rolePermission.add(perm.get("perm_code").toString());
                    }
                }
            }
            role.put("roleMenu",roleMenu);
            role.put("rolePermission",rolePermission);
        }
        return roles;
    }

    @Override
    public Map<String, Object> qryPermissionsByUcode(Map<String, Object> params) {
        List<Map<String, Object>> menus =  new ArrayList<Map<String, Object>>();
        List<String> perms =  new ArrayList<String>();
        Map<String ,Object> result= new HashMap<String ,Object>();
        List<Map<String ,Object>> list = permissionMapper.qryPermsByUser(params);
        for (Map<String, Object> map : list) {
            if(map.get("type").equals("O")){
               menus.add(map);
            }else if (map.get("type").equals("F")){
                perms.add(map.get("perm_code").toString());
            }
        }
        result.put("menus",menus);
        result.put("perms",perms);
        return result;
    }

    @Override
    public List<Map<String, Object>> getPermissionList(Map<String, Object> map) {

        return permissionMapper.getPermsList(map);
    }

    @Override
    public int insertPermission(Map<String, Object> map) {

        return 0;
    }

    @Override
    public int updatePermission(Map<String, Object> map) {

        return 0;
    }

    @Override
    public int freezePermission(Map<String, Object> map) {

        return 0;
    }

    @Override
    public PageResult getPermsPage(Map<String, Object> map) {
        PageResult page=new PageResult();
        List<Map<String ,Object>> list= permissionMapper.getPermsList(map);
        int total= permissionMapper.getPermsTotal(map);
        page.setData(list);
        page.setTotal(total);
        return page;
    }


}