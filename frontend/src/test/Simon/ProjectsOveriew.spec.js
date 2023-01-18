import { mount } from '@vue/test-utils'
import axios from 'axios'
import ProjectsOverview from "@/views/ProjectsOverview.vue";

jest.mock('axios')

describe('ProjectsOverview', () => {
    let wrapper
    beforeEach(() => {
        wrapper = mount(ProjectsOverview)
    })

    test('should get all project data on created', async () => {
        const projects = [{id: 1}, {id: 2}]
        axios.get.mockResolvedValue({data: projects})
        await wrapper.vm.getProjectData()
        expect(wrapper.vm.projects).toEqual(projects)
    })

    test('should get user data on created', async () => {
        const user = {id: 1, name: 'John'}
        axios.get.mockResolvedValue({data: user})
        await wrapper.vm.getUserData()
        expect(wrapper.vm.user).toEqual(user)
    })

    test('should get announcements for a project by id', async () => {
        const announcements = [{id: 1}, {id: 2}]
        axios.get.mockResolvedValue({data: announcements})
        await wrapper.vm.getAnnouncements(1)
        expect(wrapper.vm.announcements).toEqual(announcements)
    })

    test('should send an email', async () => {
        const specialists = [{email: 'simonvriesema@outlook.com', first_name: 'John', last_name: 'Doe'}]
        wrapper.setData({selectedProject: {specialists}})
        axios.get.mockResolvedValue({data: 'Email sent'})
        await wrapper.vm.sendEmail({target: {value: 'Hello'}})
        expect(axios.get).toHaveBeenCalled()
    })
})
