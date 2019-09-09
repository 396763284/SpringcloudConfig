import axios from 'axios'
import { Message, MessageBox } from 'element-ui'
import store from '../store'
import { getToken } from '@/utils/auth'

// 创建axios实例


// axios 配置
axios.defaults.timeout = 5000;
axios.defaults.headers.post['Content-Type'] = 'application/json';
axios.defaults.baseURL = '/wxp';




// request拦截器
axios.interceptors.request.use(config => {
    if (getToken()) {
        config.headers.Authorization = 'bearer '+`${getToken()}`;
    }
    return config
}, error => {
    // Do something with request error
    console.log(error) // for debug
    Promise.reject(error)
})

// respone拦截器
axios.interceptors.response.use(
    response => {
        /**
        * code为非20000是抛错 可结合自己业务进行修改
        */
        const res = response.data
        console.log(response.result)
        console.log("-----------------")
        console.log(response.data)
        // if(res.code==1){
        //     return res.data
        // }else{
        //     Message.error(response.msg);
        //     return res
        // }
        return res
    },
    error => {
        if (error.response) {
            Message.error("验证失败,请重新登录"+error.response.status);
            switch (error.response.status) {
                case 401:
                    // 401 清除token信息并跳转到登录页面
                    Message.error("验证失败,请重新登录");
                    //store.commit('users/clearUser');
                    router.replace({
                        path: '/login',
                        query: {redirect: router.currentRoute.fullPath}
                    });
                    break;
                case 403:
                    // 403 无权限，跳转到首页
                    router.replace({
                        path: '/login',
                        query: {redirect: router.currentRoute.fullPath}
                    });
                    break;
            }
        }
        return Promise.reject(error)
    }
)

export default axios
