import axios from '@/utils/axios'

export function login(username, password) {
    
    return axios({
        url: '/oauth/token',
        method: 'post',
        params: {
            "username": username,
            "password": password,
            "grant_type": "password",
            "scope": "all" 
        },
        auth: {
            username: 'pc',
            password: 'secret'
        }
    })
}

export function getInfo(data) {
    return axios({
        url: '/login/getUserInfo',
        method: 'post',
        data: data
    })
}

export function logout() {
    return axios({
        url: '/user/logout',
        method: 'post'
    })
}
