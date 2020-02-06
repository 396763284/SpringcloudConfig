import store from '@/store'
import router from '@/router'

import * as storage from './storage'
import {createDyTree} from './index'
import {baseRouters} from  './../router/baseRouters'
import Layout from '@/views/layout/Layout'


export function getToken() {
  return sessionStorage.getItem("currToken")
}

export function setToken(token) {
  sessionStorage.setItem("currToken",token)
  return 
}

export function removeToken() {
  return storage.clearStorage
}


// 获取用户信息
export function getUserInfo(){
  return storage.getStorage("user_info")
}

// 保存角色下所有属性 -- 因为动态路由无法保存object每次刷新页面，需要重新生成 nav_tree
export function setMenusInfo(menus){
  storage.setStorage("menus_info",menus)
  return 
}

// 获取角色下所有属性
export function getMenusInfo(){
  return storage.getStorage("menus_info")
}

// 系统登录初始化时，整理数据并保存到localstoage
export function initData(arr){
  var pers=arr.perms
  var menus=arr.menus
  createDynamic(menus)
  setMenusInfo(menus)
}


export function createDynamic(menus){
  var dynamic =baseRouters.concat(buildTree(menus))
  router.addRoutes(dynamic)
  store.commit('setNavTree',dynamic)
}

export function setUserInfo(user_info){
  storage.setStorage("user_info",user_info)
  store.commit('setUserName',user_info.user_name)
  return 
}

// 生成路由数结构  
function buildTree(currMenu){
  console.log("begin:buildTree")
    if(currMenu.length==0){
        return
    }
    var componentMenu= []
    var treeMenu=[]
    currMenu.forEach(element => {
      if(element.pid==null){
        var route = {
          id:element.permission_id,
          pid:element.pid,
          path:element.path,
          component: Layout,
          meta: {
            icon: element.icon,
            title:element.title
          }
        }
        componentMenu.push(route)
      }else{
        var childroute = {
          id:element.permission_id,
          pid:element.pid,
          path: element.path,
          component: null,
          name: element.name,
          meta: {
            icon: element.icon,
            title: element.title
          }
        }
        let url = element.import_path

        childroute['component'] = resolve => require([`@/views/${url}`], resolve)
        componentMenu.push(childroute)
      }
    })
     treeMenu = createDyTree(componentMenu,'id','pid','children',null)
     console.log(treeMenu)
    return treeMenu
}

