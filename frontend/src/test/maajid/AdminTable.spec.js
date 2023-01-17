import {mount, shallowMount} from '@vue/test-utils'
import Table from '@/components/admin/AdminsTable.vue'
import VueRouter from 'vue-router'
import AdminDetail from "@/components/admin/AdminDetail.vue";
import Vue from "vue";
import AdminsTable from "@/components/admin/AdminsTable.vue";

describe('Admin Table', () => {
    let wrapper
    const admins = [
        {id: 1, first_name: 'John', last_name: 'Doe', email: 'johndoe@email.com'},
        {id: 2, first_name: 'Jane', last_name: 'smhot', email: 'janesmith@email.com'},
        {id: 3, first_name: 'Jane', last_name: 'Smith', email: 'janesmith@email.com'},
        {id: 4, first_name: 'johnny', last_name: 'Smathy', email: 'johnnysmathy@email.com'},
        {id: 5, first_name: 'jinny', last_name: 'Soth', email: 'jinnysoth@email.com'}
    ]

    // global.Vue = require('vue');
    // const localVue = global.Vue;
    // localVue.use(VueRouter)
    // const router = new VueRouter({
    //     routes: [
    //         { path: '/admin/detail/:id', component: AdminDetail },
    //         // other routes
    //     ]
    // })
    const $router = { push: jest.fn() }

    beforeEach(() => {
        wrapper = mount(Table, {
            data() {
                return {
                    admins
                }
            },
            mocks: {
                $router: {
                    push: jest.fn()
                }
            }
        })
    })

    it('shows the correct number of admins', () => {

        const totalCount = wrapper.find('.totalCount')
        expect(totalCount.text()).toBe('5')
    })

    it('shows the correct number of admins in data object', () => {

        let nAdmins = wrapper.vm.admins.length

        expect(nAdmins).toBe(5)

    })

    // it("button takes u to detail", async () => {
    //
    //     const trs = wrapper.findAll('tr').find(tr => tr.text().includes('Y.elsherbini'));
    //     trs.trigger('click');
    //     await wrapper.vm.$nextTick()
    //
    //     expect(wrapper.vm.$options.mocks.$router.push).toHaveBeenCalledWith('/admin/detail/1')
    //
    //
    // })

})