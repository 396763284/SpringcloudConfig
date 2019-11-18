import router from '@/router'
import store from '@/store'
import NProgress from 'nprogress' // Progress 进度条
import 'nprogress/nprogress.css'// Progress 进度条样式
import { Message } from 'element-ui'
import { getToken,removeToken,createDynamic,getMenusInfo } from '@/utils/auth' // 验权

const whiteList = ['/login','404'] // 不重定向白名单

router.beforeEach((to, from, next) => {
    let token = getToken()
    NProgress.start()
    if (to.path === '/login') {
        removeToken()
        next()
    }else if((whiteList.indexOf(to.path) >= 0)){
        next()
    }else{
        if(token){
            //判断是否第一次登录，如果第一次登录，拉取用户信息
            console.log('判断是否第一次登录，如果第一次登录，拉取用户信息')
            if(from.path === '/login'){
                store.dispatch('GetInfo').then(res => { // 拉取用户信息
                    console.log(res)
                    next()
                }
            ).catch((err) => {
                store.dispatch('LogOut').then(() => {
                Message.error(err || 'Verification failed, please login again')
                next({ path: '/login' })
                })
            })
            }else{
              // 解决 刷新页面 动态路由失效的问题
                if(store.state.menu.navTree==''){
                  var localMenu= getMenusInfo()
                  console.log(localMenu)
                  createDynamic(localMenu)
                  next({ ...to, replace: true })
                }else{
                    next()
                }            
            }
          }else{
            next({
              path: '/login',
             });
          }
    }
})

router.afterEach(() => { 
    NProgress.done() // 结束Progress
})

function createTree(cloneData, id, parentId, children){   
    return cloneData.filter(father=>{
        let branchArr = cloneData.filter(child => father[id] == child[parentId]);
        branchArr.length>0 ? father[children] = branchArr : ''
        return father[parentId] == null        
    })
  }