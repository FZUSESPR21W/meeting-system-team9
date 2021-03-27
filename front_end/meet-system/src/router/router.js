import Vue from 'vue'
import VueRouter from 'vue-router'

Vue.use(VueRouter)

// 引入组件
const login = () => import('../components/login.vue')
const home = () => import('../components/home.vue')
const meeting = () => import('../components/meeting.vue')
const forum = () => import('../components/forum.vue')
const person_info = () => import('../components/person_info.vue')
const send_message = () => import('../components/send_message.vue')

const router = new VueRouter({
    mode: 'history',
    base: '',
    routes: [
        {
            path: '/',
            redirect: { name: 'meeting' },
        },
        {
            path: '/home',
            component: home,
            name: 'home',
            children: [
                {
                    path: 'meeting',
                    component: meeting,
                    name: 'meeting',
                },
                {
                    path: 'forum',
                    component: forum,
                    name: 'forum',
                },
                {
                    path: 'person_info',
                    component: person_info,
                    name: 'person_info',
                },
                {
                    path: 'send_message',
                    component: send_message,
                    name: 'send_message'
                }
            ]
        },
        {
            path: '/login',
            component: login,
            name: 'login',
        }
    ]
})

router.beforeEach((to, from, next) => {
    let id = localStorage.getItem("id");
    if (id != null || to.name == "login" || to.name == "meeting")
        next();
    else
        next({
            name: 'login'
        });
})

const originalPush = VueRouter.prototype.push
VueRouter.prototype.push = function push(location) {
    return originalPush.call(this, location).catch(err => err)
}

export default router