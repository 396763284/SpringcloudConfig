import axios from '@/utils/axios'
import {RequestMapParams} from './../utils/request'


//  统一接口
export function api(query,url) {
    let body=RequestMapParams(query,url)
    console.log(body)
    return axios({
        url: url,
        method: 'post',
        data: body
    })
}

//  统一接口
export function api_download() {
    return axios({
        url: '/rpt/download',
        method: 'get',
        responseType : 'arraybuffer'
    })
}