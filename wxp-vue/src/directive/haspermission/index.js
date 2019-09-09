import { getToken,removeToken,setRoleInfo,getRoleInfo } from '@/utils/auth' // 验权

import Vue from "vue";
import store from "../../store";

Vue.directive('has', {
  bind: function(el, binding) {
    if (!Vue.prototype.$_has(binding.value)) {
        el.style.visibility="hidden"
      //el.parentNode.removeChild(el)
    }
  }
})
// 权限检查方法（且把该方法添加到vue原型中）
Vue.prototype.$_has = function(value) {
  let isExist = false
  // 从浏览器缓存中获取权限数组（该数组在登入成功后拉取用户的权限信息时保存在浏览器的缓存中）
  var buttonpermsStr = ['RolesAdd']
  
  if (buttonpermsStr === undefined || buttonpermsStr == null) {
    return false
  }
  if (buttonpermsStr.indexOf(value) >= 0) {
    // 若在按钮中定义的权限字段能在后端返回的权限数组中能找到，则该按钮可显示
    isExist = true
  }
  return isExist
}
