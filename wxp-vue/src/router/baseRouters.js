import Layout from '@/views/layout/Layout'


export const  baseRouters = [
    { path: '/login', component: () => import('@/views/login/index'), hidden: true },
    { path: '/404', component: () => import('@/views/404'), hidden: true },
    {
        path: '/',
        component: Layout,
        meta: {
	        title: 'Dashboard'
	    },
        redirect: '/dashboard',
        hidden: true,
        children: [{
            path: '/dashboard',
            component: () => import('@/views/dashboard/index')
        }]
    }
    
  ]