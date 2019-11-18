import axios from '@/utils/axios'


export function queryEchartsMap(data) {
    return axios({
        url: '/echarts/queryEchartsMap',
        method: 'post',
        data: data
    })
}

export function queryEchartsList(data) {
    return axios({
        url: '/echarts/queryEchartsList',
        method: 'post',
        data: data
    })
}


export function queryEchartsBarArray(data) {
    return axios({
        url: '/echarts/queryEchartsBarArray',
        method: 'post',
        data: data
    })
}


export function queryEchartsPieBarArray(data) {
    return axios({
        url: '/echarts/queryEchartsPieBarArray',
        method: 'post',
        data: data
    })
}