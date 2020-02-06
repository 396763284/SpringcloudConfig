import { login, logout, getInfo } from '@/api/login'
import { initData, setToken, removeToken,setUserInfo } from '@/utils/auth'

const user = {
  state: {
    token: '',
    name: '',
    user_code:'',
    avatar: '',
    perms:[]
  },

  mutations: {
    setUserCode: (state,userCode) =>{
      state.user_code = userCode
    },
    SET_TOKEN: (state, token) => {
      state.token = token
    },
    SET_NAME: (state, name) => {
      state.name = name
    },
    SET_AVATAR: (state, avatar) => {
      state.avatar = avatar
    },
    SET_PERMS: (state,perms) =>{
      state.perms = perms
    },
    clearUser:(state)=>{
      localStorage.clear();
    }
  },

  actions: {
    // 登录
    Login({ commit }, userInfo) {
      const usercode = userInfo.username.trim()
      return new Promise((resolve, reject) => {
        login(usercode, userInfo.password).then(data => {
            setToken(data.access_token)
            commit('setUserCode',usercode)
          resolve()
        }).catch(error => {
          reject(error)
        })
      })
    },

    // 获取用户信息
    GetInfo({ commit, state }) {
      return new Promise((resolve, reject) => {
        let query ={
          user_code:state.user_code
        }
        getInfo(query).then(response => {
          console.log(response)
          initData(response.data.perms_info)
          setUserInfo(response.data.user_info)
          resolve(response)
        }).catch(error => {
          reject(error)
        })
      })
    },

    // 登出
    LogOut({ commit, state }) {
      return new Promise((resolve, reject) => {
        logout(state.token).then(() => {
          commit('SET_TOKEN', '')
          removeToken()
          resolve()
        }).catch(error => {
          reject(error)
        })
      })
    }
  }
}

export default user
