import Vue from 'vue'
import Router   from 'vue-router'
import {baseRouters} from  './baseRouters'

Vue.use(Router);


// 路由配置
const RouterConfig = {
  mode: 'history',
  routes: baseRouters
};
const router = new Router(RouterConfig);


export default router;

