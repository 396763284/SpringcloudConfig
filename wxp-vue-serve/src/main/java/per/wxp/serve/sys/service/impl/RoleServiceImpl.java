package per.wxp.serve.sys.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import per.wxp.serve.common.model.PageResult;
import per.wxp.serve.sys.mapper.RoleMapper;
import per.wxp.serve.sys.service.RoleService;
import java.util.List;
import java.util.Map;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;

    @Override
    public List<String> findRolesByUid(long id) {
        return roleMapper.findRolesByUid(id);
    }

    @Override
    public PageResult getRolePage(Map<String, Object> map) {
        PageResult page=new PageResult();
        List<Map<String ,Object>> list= roleMapper.getRoleList(map);
        int total= roleMapper.getRoleTotal(map);
        page.setData(list);
        page.setTotal(total);
        return page;

    }

    @Override
    public List<Map<String,Object>> getRoleList(Map<String, Object> map) {



        return roleMapper.getRoleList(map);
    }

    @Override
    public int insertRole(Map<String, Object> map) {

        return roleMapper.insertRole(map);
    }

    @Override
    public int updateRole(Map<String, Object> map) {

        return roleMapper.updateRole(map);
    }

    @Override
    public int freezeRole(Map<String, Object> map) {
        return 0;
    }

    @Override
    public int updateRolePermissions(Map<String, Object> map) {
        roleMapper.delRolePermsRel(map);

        roleMapper.insertRolePermsRel(map);

        return 0;

    }

    @Override
    public int insertRolePermissions(Map<String, Object> map) {
        return 0;
    }

    @Override
    public List<Map<String, Object>> getPermsByRoleId(Map<String, Object> map) {
        return roleMapper.getPermsByRoleId(map);
    }
}
