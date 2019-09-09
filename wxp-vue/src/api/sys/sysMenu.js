import axios from '@/utils/axios'



// 获取用户列表
export function menuList(data) {
    return axios({
        url: '/menus',
        method: 'post',
        data: data
    })
}