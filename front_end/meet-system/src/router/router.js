import Vue from 'vue'
import VueRouter from 'vue-router'

Vue.use(VueRouter)

// 引入组件
// const home = () => import('../components/home.vue')

const router = new VueRouter({
    mode: 'history',
    base: '',
    routes: [
        // {
        //     path: '/',
        //     redirect: { name: 'home' },
        // },
    ]
})

export default router