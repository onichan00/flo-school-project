import {mount, shallowMount} from '@vue/test-utils'
import Table from '@/components/admin/AdminsTable.vue'

describe('Admin Table', () => {
    let wrapper

    // declaring a list of admin objects
    const admins = [
        {id: 1, first_name: 'John', last_name: 'Doe', email: 'johndoe@email.com'},
        {id: 2, first_name: 'Jane', last_name: 'smhot', email: 'janesmith@email.com'},
        {id: 3, first_name: 'Jane', last_name: 'Smith', email: 'janesmith@email.com'},
        {id: 4, first_name: 'johnny', last_name: 'Smathy', email: 'johnnysmathy@email.com'},
        {id: 5, first_name: 'jinny', last_name: 'Soth', email: 'jinnysoth@email.com'}
    ]

    // insantiating a list of admins before each test
    beforeEach(() => {
        wrapper = mount(Table, {
            data() {
                return {
                    admins
                }
            }
        })
    })

    // checks if the number at the top of the page is correct
    it('shows the correct number of admins', () => {

        const totalCount = wrapper.find('.totalCount')
        expect(totalCount.text()).toBe('5')
    })

    // checks if the number of rows matches the number of admins in the data
    it('shows the correct number of admins in data object', () => {

        let nAdmins = wrapper.vm.admins.length

        expect(nAdmins).toBe(5)

    })

})