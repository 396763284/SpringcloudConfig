import axios from '@/utils/axios'



// 获取用户列表
export function taskLists(data) {
    console.log(data)
    return axios({
        url: '/sync/tasks',
        method: 'post',
        data: data
    })
}