import axios from '@/utils/axios'


//  统一接口
export function api_download() {
    return axios({
        url: '/rpt/download',
        method: 'get',
        responseType : 'arraybuffer'
    })
}