import axios from '@/utils/axios'


// 获取用户列表
export function userList(data) {
    return axios({
        url: '/users',
        method: 'post',
        data: data
    })
}
// 获取角色列表
export function userRoleList(data) {
    return axios({
        url: '/users',
        method: 'post',
        params: data
    })
}

// 保存
export function userSave(data, formName) {
    let url =
        formName === "add"
            ? "/admin/auth/admin/save"
            : "/admin/auth/admin/edit";
    return axios({
        url: url,
        method: 'post',
        data: data
    });
}

// 删除管理员
export function userDelete(data) {
    return axios({
        url: "/admin/auth/admin/delete",
        method: "post",
        data: data
    });
}